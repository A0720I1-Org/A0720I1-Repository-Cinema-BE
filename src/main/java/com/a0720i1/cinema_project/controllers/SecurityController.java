package com.a0720i1.cinema_project.controllers;

import com.a0720i1.cinema_project.config.JwtTokenUtil;
import com.a0720i1.cinema_project.jwt.JwtResponse;
import com.a0720i1.cinema_project.jwt.LoginRequest;
import com.a0720i1.cinema_project.jwt.SocialResponse;
import com.a0720i1.cinema_project.models.dto.account.AccountDTO;
import com.a0720i1.cinema_project.models.dto.account.AccountMemberDTO;
import com.a0720i1.cinema_project.models.entity.Account;
import com.a0720i1.cinema_project.models.entity.Membership;
import com.a0720i1.cinema_project.services.AccountRoleService;
import com.a0720i1.cinema_project.services.AccountService;
import com.a0720i1.cinema_project.services.Impl.AccountDetailServiceImpl;
import com.a0720i1.cinema_project.services.Impl.AccountDetailsImpl;
import com.a0720i1.cinema_project.services.MemberShipService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class SecurityController {
    static final String googleClientId = "464151182023-kk3t1i54nkc4quc4ibp7rcuk05q5dn5v.apps.googleusercontent.com";
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AccountDetailServiceImpl accountDetailService;
    @Autowired
    private AccountRoleService accountRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AccountService accountService;
    @Autowired
    private MemberShipService memberShipService;
    @PostMapping(value = "/api/public/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest loginRequest) throws Exception {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
        } catch (Exception e
        ) {
            if (accountService.findByUsername(loginRequest.getUsername()) != null) {
                throw new BadCredentialsException("T??n ????ng nh???p ho???c m???t kh???u kh??ng ch??nh x??c!", e);
            } else {
                throw new UsernameNotFoundException("T??n ????ng nh???p kh??ng t???n t???i!", e);
            }
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generateJwtToken(loginRequest.getUsername());
        AccountDetailsImpl userDetails = (AccountDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountService.findByUsername(loginRequest.getUsername());
        Membership membership = memberShipService.findByAccountId(account.getId());
        account.setPassword("");
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return ResponseEntity.ok(
                new JwtResponse(jwt, account,membership, roles)
        );
    }
    @PostMapping("/api/public/oauth/google")
    public ResponseEntity<?> loginGoogle(@RequestBody SocialResponse jwtResponseSocial) throws IOException {
        final NetHttpTransport netHttpTransport = new NetHttpTransport();
        final JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();
        GoogleIdTokenVerifier.Builder builder =
                new GoogleIdTokenVerifier.Builder(netHttpTransport, jacksonFactory)
                        .setAudience(Collections.singletonList(googleClientId));
        final GoogleIdToken googleIdToken = GoogleIdToken.parse(builder.getJsonFactory(), jwtResponseSocial.getToken());
        final GoogleIdToken.Payload payload = googleIdToken.getPayload();
        Membership membership = memberShipService.findByEmail(payload.getEmail());
        Account account = new Account();
        JwtResponse jwtResponse = new JwtResponse();
        if (membership == null) {
            membership = new Membership();
            account.setUsername(payload.getEmail());
            account.setPassword(passwordEncoder.encode(""));
            accountService.createAccount(account.getUsername(),account.getPassword());
            accountRoleService.createAccountRole(accountService.findByUsername(payload.getEmail()).getId(),2);//Role 2 l?? role member
            membership.setEmail(payload.getEmail());
            membership.setAccount(accountService.findByUsername(payload.getEmail()));
            memberShipService.createMembershipSocial(membership);
            LoginRequest jwtRequest = new LoginRequest(account.getUsername(), account.getPassword());
            jwtResponse = loginSocial(jwtRequest);
            jwtResponse.setAccount(accountService.findByUsername(account.getUsername()));
            jwtResponse.setMembership(memberShipService.findByEmail(payload.getEmail()));
            return ResponseEntity.ok(jwtResponse);
        }
        account = membership.getAccount();
        LoginRequest jwtRequest = new LoginRequest(account.getUsername(), account.getPassword());
        jwtResponse = loginSocial(jwtRequest);
        jwtResponse.setAccount(accountService.findByUsername(account.getUsername()));
        jwtResponse.setMembership(memberShipService.findByAccountId(account.getId()));
        return ResponseEntity.ok(jwtResponse);
    }
    @PostMapping("/api/public/oauth/facebook")
    public ResponseEntity<?> loginFacebook(@RequestBody SocialResponse jwtResponseSocial) {
        Facebook facebook = new FacebookTemplate(jwtResponseSocial.getToken());
        final String[] fields = {"email", "name"};
        org.springframework.social.facebook.api.User user = facebook
                .fetchObject("me", org.springframework.social.facebook.api.User.class, fields);
        Membership membership = memberShipService.findByEmail(user.getEmail());
        Account account = new Account();
        JwtResponse jwtResponse = new JwtResponse();
        if (membership == null) {
            membership = new Membership();
            account.setUsername(user.getEmail());
            account.setPassword(passwordEncoder.encode(""));
            accountService.createAccount(account.getUsername(),account.getPassword());
            accountRoleService.createAccountRole(accountService.findByUsername(user.getEmail()).getId(),2);//Role 2 l?? role member
            membership.setEmail(user.getEmail());
            membership.setAccount(accountService.findByUsername(user.getEmail()));
            memberShipService.createMembershipSocial(membership);
            LoginRequest jwtRequest = new LoginRequest(account.getUsername(), account.getPassword());
            jwtResponse = loginSocial(jwtRequest);
            jwtResponse.setAccount(accountService.findByUsername(account.getUsername()));
            jwtResponse.setMembership(memberShipService.findByEmail(user.getEmail()));
            return ResponseEntity.ok(jwtResponse);
        }
        account = membership.getAccount();
        LoginRequest jwtRequest = new LoginRequest(account.getUsername(), account.getPassword());
        jwtResponse = loginSocial(jwtRequest);
        jwtResponse.setAccount(accountService.findByUsername(account.getUsername()));
        jwtResponse.setMembership(memberShipService.findByAccountId(account.getId()));
        return ResponseEntity.ok(jwtResponse);
    }
    private JwtResponse loginSocial(LoginRequest loginRequest) {
        final UserDetails userDetails = accountDetailService
                .loadUserByUsername(loginRequest.getUsername());
        final String token = jwtTokenUtil.generateJwtToken(userDetails.getUsername());
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return new JwtResponse(token,roles);
    }
    @PutMapping("/api/public/forgot-password/{username}")
    public ResponseEntity<?> forgotPassword(@PathVariable String username) {
        Account account = accountService.findByUsername(username);
        Map<String, String> listError = new HashMap<>();
        if(account == null) {
            listError.put("nonExistUsername", "T??n ????ng nh???p kh??ng t???n t???i , vui l??ng ch???n t??n ????ng nh???p kh??c!");
            if(!listError.isEmpty()) {
                return ResponseEntity
                        .badRequest()
                        .body(listError);
            }
        }
        Membership membership = memberShipService.findByAccountId(account.getId());
        String email = membership.getEmail();
        String code = accountService.generateCode();
        accountService.sendEmailOTP(email,code);
        return ResponseEntity.ok(code);
    }
    @GetMapping("/api/public/reset-password/{username}")
    public ResponseEntity<?> resetPassword(@PathVariable String username) {
        Account account = accountService.findByUsername(username);
        accountService.changePasswordByForgot("12345678",account);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/api/public/register")
    public ResponseEntity<?> register(@RequestBody AccountMemberDTO accountMemberDTO) {
        try {
            Map<String, String> listError = new HashMap<>();
            if (memberShipService.findByEmail(accountMemberDTO.getEmail()) != null) {
                listError.put("existEmail", "Email ???? t???n t???i , vui l??ng nh???p email kh??c!");
            }
            if (accountService.findByUsername(accountMemberDTO.getUsername()) != null) {
                listError.put("existUsername", "T??n ????ng nh???p ???? t???n t???i , vui l??ng nh???p T??n ????ng nh???p kh??c!");
            }
            if (memberShipService.findByCard(accountMemberDTO.getCard()) != null) {
                listError.put("existCard", "CMND ???? t???n t???i , vui l??ng nh???p CMND kh??c!");
            }
            if(memberShipService.findByPhone(accountMemberDTO.getPhone()) != null) {
                listError.put("existPhone", "S??? ??i???n tho???i ???? t???n t???i , vui l??ng nh???p s??? ??i???n tho???i kh??c!");
            }
            if (!listError.isEmpty()) {
                return ResponseEntity
                        .badRequest()
                        .body(listError);
            }
            accountService.createAccount(accountMemberDTO.getUsername(),accountMemberDTO.getPassword());
            memberShipService.createMembership(accountMemberDTO);
            Account account = accountService.findByUsername(accountMemberDTO.getUsername());
            accountRoleService.createAccountRole(account.getId(),2);//role member = 2
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/api/member/password/{username}")
    public ResponseEntity<?> changePassword(@RequestBody AccountDTO accountDTO,
                                            @PathVariable String username) {
        Account account = accountService.findByUsername(username);
        Map<String, String> listError = new HashMap<>();
        if(!accountService.checkChangePassword(account,accountDTO)){
            listError.put("failPassword", "M???t kh???u c?? sai");
        }
        if(accountService.checkNewPwEqualOldPw(account,accountDTO)){
            listError.put("equalPassword", "M???t kh???u m???i tr??ng v???i m???t kh???u c?? n??n b???n kh??ng c???n thay ?????i!");
        }
        if (!listError.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(listError);
        }
        accountService.changePassword(account,accountDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
