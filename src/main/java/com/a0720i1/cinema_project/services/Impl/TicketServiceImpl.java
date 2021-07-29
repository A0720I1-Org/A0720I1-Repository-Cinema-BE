package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.models.dto.ticket.BookingTicketDTO;
import com.a0720i1.cinema_project.models.dto.ticket.TicketDTO;
import com.a0720i1.cinema_project.models.entity.Invoice;
import com.a0720i1.cinema_project.models.entity.Ticket;
import com.a0720i1.cinema_project.repositories.InvoiceRepository;
import com.a0720i1.cinema_project.repositories.TicketRepository;
import com.a0720i1.cinema_project.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public long createTicket(long invoiceId) {
        Invoice invoice = invoiceRepository.getById(invoiceId);
        Ticket ticket = new Ticket();
        ticket.setInvoice(invoice);
        ticket = ticketRepository.save(ticket);
        return ticket.getId();
    }

    @Override
    public List<TicketDTO> getAllTicketByInvoiceId(long invoiceId) {
        return ticketRepository.getAllTicketByInvoiceId(invoiceId);
    }
}
