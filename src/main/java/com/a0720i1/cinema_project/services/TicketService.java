package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.dto.ticket.BookingTicketDTO;
import com.a0720i1.cinema_project.models.dto.ticket.TicketDTO;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public interface TicketService {
    long createTicket(long invoiceId);
    List<BookingTicketDTO> getAllTicketByInvoiceId(long invoiceId);
    Page<TicketDTO> findTicketOfMembership(Pageable pageable, Long memberId);
}
