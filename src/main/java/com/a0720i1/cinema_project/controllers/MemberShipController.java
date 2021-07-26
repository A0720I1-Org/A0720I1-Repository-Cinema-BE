package com.a0720i1.cinema_project.controllers;
import com.a0720i1.cinema_project.models.dto.membership.MembershipUpdateDTO;
import com.a0720i1.cinema_project.models.entity.*;
import com.a0720i1.cinema_project.services.Impl.AccountServiceImpl;
import com.a0720i1.cinema_project.services.Impl.DistrictServiceImpl;
import com.a0720i1.cinema_project.services.Impl.ProvinceServiceImpl;
import com.a0720i1.cinema_project.services.Impl.WardServiceImpl;
import com.a0720i1.cinema_project.services.MemberShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MemberShipController {
    @Autowired
    MemberShipService memberShipService;
    @Autowired
    WardServiceImpl wardService;
    @Autowired
    DistrictServiceImpl districtService;
    @Autowired
    ProvinceServiceImpl provinceService;
    @Autowired
    AccountServiceImpl accountService;
    @GetMapping("/api/public/ward")
    public ResponseEntity<List<Ward>> findWardByDistrictId(@RequestParam(value = "districtId",required = false) Integer districtId) {
        if(districtId == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(wardService.findAllByDistrictId(districtId));
    }
    @GetMapping("/api/public/district")
    public ResponseEntity<List<District>> findDistrictByDistrictId(@RequestParam(value = "provinceId",required = false) Integer provinceId) {
        if(provinceId == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(districtService.findAllByProvinceId(provinceId));
    }
    @GetMapping("/api/public/province")
    public ResponseEntity<List<Province>> findProvince() {
        return ResponseEntity.ok(provinceService.findAll());
    }
    @GetMapping("/api/public/membership")
    public ResponseEntity<Membership> findMembershipByAccountId(@RequestParam(value = "accountId",required = false) Long accountId){
        if(accountId == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(memberShipService.findByAccountId(accountId));
    }
    @PutMapping(value = "/api/public/membership",produces = {MediaType.APPLICATION_JSON_VALUE},consumes ={MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<?> updateMembership(@RequestBody MembershipUpdateDTO membership) {
        if(membership == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        memberShipService.updateMembership(membership);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/api/public/membership/{username}")
    public ResponseEntity<Membership> getMembership(@PathVariable String username) {
        Account account = accountService.findByUsername(username);
        if(account == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(memberShipService.findByAccountId(account.getId()),HttpStatus.OK);
    }
}
