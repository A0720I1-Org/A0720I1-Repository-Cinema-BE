package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.dto.showtime.CreateShowtimeDTO;
import com.a0720i1.cinema_project.models.entity.CinemaRoom;
import com.a0720i1.cinema_project.models.entity.Film;
import com.a0720i1.cinema_project.models.entity.Showtime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

//anh don
import com.a0720i1.cinema_project.models.dto.ticket.BookTicketShowtimeDto;
import com.a0720i1.cinema_project.models.dto.ticket.CinemaRoomLayout;
import com.a0720i1.cinema_project.models.dto.ticket.BookingSeatDTO;


public interface ShowTimeService {
    void createShowtimeDTO(CreateShowtimeDTO createShowtimeDTO);

    List<Film> findAllFilm();

    List<CinemaRoom> findAllCinemaRoom();

    Long getMaxByIdShowtime();

    Showtime getShowtimeById(long id);

    List<BookTicketShowtimeDto> getAllFilmShowingThisWeek();

    List<BookingSeatDTO> getAllSeatByShowtimeId(long showtimeId);

    CinemaRoomLayout getCinemaRoomLayoutByShowtimeId(long showtimeId);

    BookTicketShowtimeDto getShowtimeByInvoiceId(long invoiceId);

    void createSeat(String name, long showtimeId, long ticketPriceId);
}



