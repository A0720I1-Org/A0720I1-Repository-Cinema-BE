package com.a0720i1.cinema_project.repositories;

import com.a0720i1.cinema_project.models.dto.ticket.TicketDTO;
import com.a0720i1.cinema_project.models.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query(value = "select ticket.id as id, ticket.invoice_id as invoiceId, seat.id as seatId, seat.name as seatName, " +
            "ticket_price.seat_code as seatCode, ticket_price.seat_type as seatType, ticket_price.price as price " +
            "from ticket left join seat on ticket.id = seat.ticket_id " +
            "left join ticket_price on seat.ticket_price_id =  ticket_price.id where ticket.invoice_id = ?1", nativeQuery = true)
    List<TicketDTO> getAllTicketByInvoiceId(long invoiceId);
}
