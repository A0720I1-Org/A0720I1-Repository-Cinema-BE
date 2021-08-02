package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.models.dto.ticket.TicketDTO;
import com.a0720i1.cinema_project.repositories.TicketRepository;
import com.a0720i1.cinema_project.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Override
    public Page<TicketDTO> findTicketOfMembership(Pageable pageable, Long memberId) {
        return ticketRepository.findTicketByMembership(pageable,memberId);
    }
}
