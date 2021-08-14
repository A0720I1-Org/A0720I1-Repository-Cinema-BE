package com.a0720i1.cinema_project.services.Impl;
//vu
import com.a0720i1.cinema_project.models.dto.showtime.CreateShowtimeDTO;
import com.a0720i1.cinema_project.models.entity.CinemaRoom;
import com.a0720i1.cinema_project.models.entity.Film;
import com.a0720i1.cinema_project.models.entity.Showtime;
import com.a0720i1.cinema_project.repositories.CinemaRoomRepository;
import com.a0720i1.cinema_project.repositories.FilmRepository;
//anh don
import com.a0720i1.cinema_project.models.dto.ticket.BookTicketShowtimeDto;
import com.a0720i1.cinema_project.models.dto.ticket.CinemaRoomLayout;
import com.a0720i1.cinema_project.models.dto.ticket.BookingSeatDTO;
import com.a0720i1.cinema_project.repositories.ShowTimeRepository;
import com.a0720i1.cinema_project.services.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ShowTimeServiceImpl implements ShowTimeService {

    @Autowired
    private ShowTimeRepository showTimeRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private CinemaRoomRepository cinemaRoomRepository;

    @Override
    public void createShowtimeDTO(CreateShowtimeDTO createShowtimeDTO) {
        showTimeRepository.createShowtimeDTO(createShowtimeDTO.getFilmTechnology(),
                                                createShowtimeDTO.getSubTitle(),
                                                createShowtimeDTO.getDay(),
                                                createShowtimeDTO.getTime(),
                                                createShowtimeDTO.getFilmId(),
                                                createShowtimeDTO.getCinemaRoomId());
    }

    @Override
    public List<Film> findAllFilm() {
        return filmRepository.findAll();
    }

    @Override
    public List<CinemaRoom> findAllCinemaRoom() {
        return cinemaRoomRepository.findAll();
    }

    @Override
    public Long getMaxByIdShowtime() {
        return showTimeRepository.getMaxIdShowtime();
    }

    @Override
    public Showtime getShowtimeById(long id) {
        return showTimeRepository.findById(id).orElse(null);
    }

    @Override
    public List<BookTicketShowtimeDto> getAllFilmShowingThisWeek() {
        return showTimeRepository.getAllFilmShowingThisWeek();
    }

    @Override
    public List<BookingSeatDTO> getAllSeatByShowtimeId(long showtimeId) {
        return showTimeRepository.getAllSeatByShowtimeId(showtimeId);
    }

    @Override
    public CinemaRoomLayout getCinemaRoomLayoutByShowtimeId(long showtimeId) {
        return showTimeRepository.getCinemaRoomLayoutByShowtimeId(showtimeId);
    }

    @Override
    public BookTicketShowtimeDto getShowtimeByInvoiceId(long invoiceId) {
        return showTimeRepository.getShowtimeByInvoiceId(invoiceId);
    }

    @Override
    public void createSeat(String name, long showtimeId, long ticketPriceId) {
        showTimeRepository.createSeat(name, showtimeId, ticketPriceId);
    }


}
