package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.models.dto.ticket.BookTicketShowtimeDto;
import com.a0720i1.cinema_project.models.dto.ticket.CinemaRoomLayout;
import com.a0720i1.cinema_project.models.dto.ticket.BookingSeatDTO;
import com.a0720i1.cinema_project.repositories.ShowTimeRepository;
import com.a0720i1.cinema_project.services.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowTimeServiceImpl implements ShowTimeService {
    @Autowired
    ShowTimeRepository showTimeRepository;

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
}
