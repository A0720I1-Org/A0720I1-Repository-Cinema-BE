package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.dto.ticket.BookingTicketDTO;
import com.a0720i1.cinema_project.models.dto.ticket.TicketDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {
    long createTicket(long invoiceId);
    List<TicketDTO> getAllTicketByInvoiceId(long invoiceId);
}
