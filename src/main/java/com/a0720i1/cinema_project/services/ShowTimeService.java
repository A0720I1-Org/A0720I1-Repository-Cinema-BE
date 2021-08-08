package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.dto.showtime.CreateShowtimeDTO;
import com.a0720i1.cinema_project.models.entity.CinemaRoom;
import com.a0720i1.cinema_project.models.entity.Film;
import com.a0720i1.cinema_project.models.entity.Showtime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ShowTimeService {
//    ListShowTimeDTO getShowtimeById(long id);
    void createShowtimeDTO(CreateShowtimeDTO createShowtimeDTO);
    List<Film> findAllFilm();
    List<CinemaRoom> findAllCinemaRoom();
    Long getMaxByIdShowtime();
    Showtime getShowtimeById(long id);
}
