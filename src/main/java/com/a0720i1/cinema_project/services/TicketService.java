package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.dto.ticket.TicketDTO;
import com.a0720i1.cinema_project.models.dto.ticket.TicketMemberDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {
    Page<TicketDTO> findTicketOfMembership(Pageable pageable, Long memberId);
    Page<TicketMemberDTO> findAllTicket(Pageable pageable);
    void updatePrintedTicket(Long invoiceId);
    Page<TicketMemberDTO> findAllTicketBySearch(String key,Pageable pageable);
}
