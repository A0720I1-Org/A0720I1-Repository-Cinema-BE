package com.a0720i1.cinema_project.controllers;

import com.a0720i1.cinema_project.models.dto.ticket.TicketMemberDTO;
import com.a0720i1.cinema_project.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InvoiceController {
    @Autowired
    TicketService ticketService;
    @GetMapping("/api/public/invoice")
    public ResponseEntity<Page<TicketMemberDTO>> getAllTicket(@PageableDefault(value = 5) Pageable pageable) {
        Page<TicketMemberDTO> tickets = ticketService.findAllTicket(pageable);
        if (tickets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tickets,HttpStatus.OK);
    }
    @GetMapping("/api/public/invoice/{key}")
    public ResponseEntity<Page<TicketMemberDTO>> getAllTicketBySearch(@PathVariable("key") String key,@PageableDefault(value = 5) Pageable pageable) {
        Page<TicketMemberDTO> tickets = ticketService.findAllTicketBySearch(key,pageable);
        if (tickets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tickets,HttpStatus.OK);
    }
    @PutMapping("/api/public/invoice/{id}")
    public ResponseEntity<?> updateTicketPrinted(@PathVariable("id") Long invoiceId) {
        ticketService.updatePrintedTicket(invoiceId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
