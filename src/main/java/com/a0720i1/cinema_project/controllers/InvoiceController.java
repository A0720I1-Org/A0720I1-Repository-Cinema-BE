package com.a0720i1.cinema_project.controllers;

import com.a0720i1.cinema_project.models.dto.ticket.*;
import com.a0720i1.cinema_project.models.entity.Membership;
import com.a0720i1.cinema_project.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;
    @Autowired
    TicketService ticketService;
    @Autowired
    SeatService seatService;
    @Autowired
    ShowTimeService showTimeService;
    @Autowired
    MemberShipService memberShipService;

    @PostMapping("/api/member/invoice/create-invoice")
    @Transactional
    public ResponseEntity<?> createInvoice(@RequestBody BookingInformation bookingInformation) {
       try {
           Map<String, Long> invoice = new HashMap<>();
           long invoiceId = invoiceService.createInvoice(bookingInformation.getMemberId(), bookingInformation.getPaymentMethodId());
           System.out.println(invoiceId);
           for (long seatId : bookingInformation.getSeatIdList()) {
               long ticketId = ticketService.createTicket(invoiceId);
               seatService.updateTicketIdBySeatId(ticketId, seatId);
           }
           Membership membership = memberShipService.findById(bookingInformation.getMemberId());
           invoiceService.sendEmail(membership.getEmail(), invoiceId, showTimeService.getShowtimeByInvoiceId(invoiceId), ticketService.getAllTicketByInvoiceId(invoiceId));
           invoice.put("id", invoiceId);
           return new ResponseEntity<>(invoice,HttpStatus.CREATED);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }
    @GetMapping("/api/member/invoice/get-invoice-by-id/{invoiceId}")
    public ResponseEntity<BookingInvoiceDTO> getInvoiceById(@PathVariable long invoiceId) {
        BookingInvoiceDTO invoice = this.invoiceService.getInvoiceByInvoiceId(invoiceId);
        if (invoice == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(invoice, HttpStatus.OK);
    }

    @GetMapping("/api/member/ticket/get-ticket-by-invoice-id")
    public ResponseEntity<List<BookingTicketDTO>> getTicketListByInvoiceId(@RequestParam long invoiceId) {
        List<BookingTicketDTO> ticketList = this.ticketService.getAllTicketByInvoiceId(invoiceId);
        if (ticketList == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }
}
