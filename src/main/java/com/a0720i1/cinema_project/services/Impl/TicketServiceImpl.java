package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.models.dto.ticket.BookingTicketDTO;
import com.a0720i1.cinema_project.models.dto.ticket.TicketDTO;
import com.a0720i1.cinema_project.models.dto.ticket.TicketMemberDTO;
import com.a0720i1.cinema_project.models.entity.Invoice;
import com.a0720i1.cinema_project.models.entity.Ticket;
import com.a0720i1.cinema_project.repositories.InvoiceRepository;
import com.a0720i1.cinema_project.repositories.TicketRepository;
import com.a0720i1.cinema_project.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;


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
    public List<BookingTicketDTO> getAllTicketByInvoiceId(long invoiceId) {
        return ticketRepository.getAllTicketByInvoiceId(invoiceId);
    }

    @Override
    public Page<TicketDTO> findTicketOfMembership(Pageable pageable, Long memberId) {
        return ticketRepository.findTicketByMembership(pageable,memberId);

    }

    @Override
    public Page<TicketMemberDTO> findAllTicket(Pageable pageable) {
        return ticketRepository.findAllTicket(pageable);
    }

    @Override
    public void updatePrintedTicket(Long invoiceId) {
        ticketRepository.updateTicketPrinted(invoiceId);
    }

    @Override
    public Page<TicketMemberDTO> findAllTicketBySearch(String key, Pageable pageable) {
        return ticketRepository.findAllTicketBySearch(key,pageable);
    }

    @Override
    public TicketMemberDTO getInvoiceMember(Long id) {
        return ticketRepository.findInvoiceMemberById(id);
    }
}
