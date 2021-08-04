package com.a0720i1.cinema_project.repositories;

import com.a0720i1.cinema_project.models.dto.ticket.BookingTicketDTO;
import com.a0720i1.cinema_project.models.dto.ticket.TicketDTO;
import com.a0720i1.cinema_project.models.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    List<BookingTicketDTO> getAllTicketByInvoiceId(long invoiceId);

    @Query(value = "select invoice.id as invoiceId,ticket.id as ticketId,showtime.day as date,showtime.time as time,sum(ticket_price.price) as price,film.name as filmName,ticket.printed as status,group_concat(seat.name) as seatName from `ticket`\n" +
            "left join invoice on ticket.invoice_id = invoice.id\n" +
            "left join membership on membership.id = invoice.membership_id\n" +
            "left join seat on seat.ticket_id = ticket.id\n" +
            "left join ticket_price on seat.ticket_price_id = ticket_price.id\n" +
            "left join showtime on seat.showtime_id = showtime.id\n" +
            "left join film on showtime.film_id = film.id\n" +
            "where membership.id=?1\n" +
            "group by invoice.id",nativeQuery = true)
    Page<TicketDTO> findTicketByMembership(Pageable pageable, Long id);
}
