package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.dto.ticket.BookTicketShowtimeDto;
import com.a0720i1.cinema_project.models.dto.ticket.CinemaRoomLayout;
import com.a0720i1.cinema_project.models.dto.ticket.BookingSeatDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShowTimeService {
    List<BookTicketShowtimeDto> getAllFilmShowingThisWeek();

    List<BookingSeatDTO> getAllSeatByShowtimeId(long showtimeId);

    CinemaRoomLayout getCinemaRoomLayoutByShowtimeId(long showtimeId);

    BookTicketShowtimeDto getShowtimeByInvoiceId(long invoiceId);
}
