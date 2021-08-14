package com.a0720i1.cinema_project.controllers;

import com.a0720i1.cinema_project.models.dto.membership.MembershipUpdateDTO;
import com.a0720i1.cinema_project.models.dto.ticket.TicketDTO;
import com.a0720i1.cinema_project.models.entity.District;
import com.a0720i1.cinema_project.models.entity.Membership;
import com.a0720i1.cinema_project.models.entity.Province;
import com.a0720i1.cinema_project.models.entity.Ward;
import com.a0720i1.cinema_project.services.Impl.AccountServiceImpl;
import com.a0720i1.cinema_project.services.Impl.DistrictServiceImpl;
import com.a0720i1.cinema_project.services.Impl.ProvinceServiceImpl;
import com.a0720i1.cinema_project.services.Impl.WardServiceImpl;
import com.a0720i1.cinema_project.services.MemberShipService;
import com.a0720i1.cinema_project.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    TicketService ticketService;
    @GetMapping("/api/public/address/ward")
    public ResponseEntity<List<Ward>> findWardByDistrictId(@RequestParam(value = "districtId",required = false) Integer districtId) {
        if(districtId == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(wardService.findAllByDistrictId(districtId));

    }
    @GetMapping("/api/public/address/district")
    public ResponseEntity<List<District>> findDistrictByDistrictId(@RequestParam(value = "provinceId",required = false) Integer provinceId) {
        if(provinceId == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(districtService.findAllByProvinceId(provinceId));
    }
    @GetMapping("/api/public/address/province")
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
    @PutMapping(value = "/api/member/membership",produces = {MediaType.APPLICATION_JSON_VALUE},consumes ={MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<?> updateMembership(@RequestBody MembershipUpdateDTO membership) {
            Map<String, String> listError = new HashMap<>();
            if(membership == null) {
                return ResponseEntity.badRequest().body("Không tìm thấy thành viên này");
            }
            if (memberShipService.findByEmail(membership.getEmail()) != null && membership.getId() != memberShipService.findByEmail(membership.getEmail()).getId()) {
                listError.put("existEmail", "Email đã tồn tại , vui lòng nhập email khác!");
            }
            if (memberShipService.findByCard(membership.getCard()) != null && membership.getId() != memberShipService.findByCard(membership.getCard()).getId()) {
                listError.put("existCard", "CMND đã tồn tại , vui lòng nhập CMND khác!");
            }
            if(memberShipService.findByPhone(membership.getPhone()) != null && membership.getId() != memberShipService.findByPhone(membership.getPhone()).getId()) {
                listError.put("existPhone", "Số điện thoại đã tồn tại , vui lòng nhập số điện thoại khác!");
            }
            if (!listError.isEmpty()) {
                return ResponseEntity
                        .badRequest()
                        .body(listError);
            }
            memberShipService.updateMembership(membership);
            return new ResponseEntity<>(membership.getId(),HttpStatus.OK);
    }
    @GetMapping("/api/member/membership/{id}")
    public ResponseEntity<Membership> getMembershipById(@PathVariable long id) {
       Membership membership = memberShipService.findById(id);
        if(membership == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(membership,HttpStatus.OK);
    }
    @GetMapping("/api/public/ticket")
    public ResponseEntity<Page<TicketDTO>> getTicketOfMember(@RequestParam long id,@PageableDefault(value=7) Pageable pageable) {
        Page<TicketDTO> tickets = ticketService.findTicketOfMembership(pageable, id);
        if (tickets == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tickets,HttpStatus.OK);
    }
}
