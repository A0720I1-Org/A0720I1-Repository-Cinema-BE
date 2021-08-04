package com.a0720i1.cinema_project.controllers;

import com.a0720i1.cinema_project.models.dto.membership.MembershipDTO;
import com.a0720i1.cinema_project.models.dto.membership.MembershipEditDTO;
import com.a0720i1.cinema_project.models.entity.Membership;
import com.a0720i1.cinema_project.services.Impl.MemberShipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class MemberShipController {
    @Autowired
    MemberShipServiceImpl memberShipService;
    @GetMapping("/api/admin/membership/get-list-membership")
    public ResponseEntity<Page<MembershipDTO>> getListMembership(@PageableDefault(value = 10)Pageable pageable) {
        Page<MembershipDTO> membershipDTOS = this.memberShipService.findAll(pageable);
        if (membershipDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(membershipDTOS, HttpStatus.OK);
    }
    @GetMapping(value = "/api/admin/membership/update-membership/{id}")
    public ResponseEntity<Membership> getMembership(@PathVariable long id) {
        Membership membership = this.memberShipService.findById(id);
        if (membership == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(membership, HttpStatus.OK);
    }
}
