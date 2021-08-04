package com.a0720i1.cinema_project.repositories;

import com.a0720i1.cinema_project.models.dto.ticket.TicketDTO;
import com.a0720i1.cinema_project.models.dto.ticket.TicketMemberDTO;
import com.a0720i1.cinema_project.models.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
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
    @Query(value = "select invoice.id as invoiceId,membership.member_code as memberCode,membership.name as memberName,membership.card as memberCard,membership.phone as memberPhone, film.name as filmName,showtime.day,showtime.time,ticket.printed from `ticket`\n" +
            "left join invoice on ticket.invoice_id = invoice.id\n" +
            "left join membership on membership.id = invoice.membership_id\n" +
            "left join seat on seat.ticket_id = ticket.id\n" +
            "left join ticket_price on seat.ticket_price_id = ticket_price.id\n" +
            "left join showtime on seat.showtime_id = showtime.id\n" +
            "left join film on showtime.film_id = film.id\n" +
            "group by invoice.id",nativeQuery = true)
    Page<TicketMemberDTO> findAllTicket(Pageable pageable);
    @Query(value = "select invoice.id as invoiceId,membership.member_code as memberCode,membership.name as memberName,membership.card as memberCard,membership.phone as memberPhone, film.name as filmName,showtime.day,showtime.time,ticket.printed from `ticket`\n" +
            "left join invoice on ticket.invoice_id = invoice.id\n" +
            "left join membership on membership.id = invoice.membership_id\n" +
            "left join seat on seat.ticket_id = ticket.id\n" +
            "left join ticket_price on seat.ticket_price_id = ticket_price.id\n" +
            "left join showtime on seat.showtime_id = showtime.id\n" +
            "left join film on showtime.film_id = film.id\n" +
//            "where concat(membership.member_code,film.name,membership.phone,membership.name,'') like %?1% \n" +
            "where membership.phone like %?1% \n" +
            "group by invoice.id",nativeQuery = true)
    Page<TicketMemberDTO> findAllTicketBySearch(String key,Pageable pageable);
    @Transactional
    @Modifying
    @Query(value = "update ticket \n" +
            "left join invoice on ticket.invoice_id = invoice.id\n" +
            "set printed = 1\n" +
            "where invoice.id= ?1",nativeQuery = true)
    void updateTicketPrinted(Long id);
}
