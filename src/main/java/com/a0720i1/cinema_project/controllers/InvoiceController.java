package com.a0720i1.cinema_project.controllers;

import com.a0720i1.cinema_project.common.SeatNotAvailableException;
import com.a0720i1.cinema_project.models.dto.ticket.*;
import com.a0720i1.cinema_project.models.entity.Invoice;
import com.a0720i1.cinema_project.models.entity.Membership;
import com.a0720i1.cinema_project.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
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

    @PostMapping("/api/member/invoice/check-seat-available")
    public ResponseEntity<?> checkSeatAvailable(@RequestBody BookingInformation bookingInformation) throws SeatNotAvailableException {
        for (long seatId : bookingInformation.getSeatIdList()) {
            if (seatService.findById(seatId).getTicket() != null) {
                throw new SeatNotAvailableException("Ghế bạn chọn đã được đặt bởi người dùng khác");
            }
        };
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/member/invoice/create-invoice")
    @Transactional
    public ResponseEntity<?> createInvoice(@RequestBody BookingInformation bookingInformation) {
       try {
           Map<String, Long> invoice = new HashMap<>();
           Invoice createdInvoice = invoiceService.createInvoice(bookingInformation.getMemberId(), bookingInformation.getPaymentMethodId(), invoiceService.generateCode());
           for (long seatId : bookingInformation.getSeatIdList()) {
               long ticketId = ticketService.createTicket(createdInvoice.getId());
               seatService.updateTicketIdBySeatId(ticketId, seatId);
           }
           Membership membership = memberShipService.findById(bookingInformation.getMemberId());
           invoiceService.sendEmail(membership.getEmail(), createdInvoice.getCode(), showTimeService.getShowtimeByInvoiceId(createdInvoice.getId()), ticketService.getAllTicketByInvoiceId(createdInvoice.getId()));
           invoice.put("id", createdInvoice.getId());
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
