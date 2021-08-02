package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.dto.ticket.TicketDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {
    Page<TicketDTO> findTicketOfMembership(Pageable pageable, Long memberId);
}
