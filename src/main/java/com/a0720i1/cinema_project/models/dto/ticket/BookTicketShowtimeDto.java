package com.a0720i1.cinema_project.models.dto.ticket;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

public interface BookTicketShowtimeDto {
    Long getFilmId();
    String getFilmName();
    String getFilmCategory();
    String getFilmActors();
    String getFilmDirectors();
    int getFilmDuration();
    int getFilmAge();
    String getFilmImageUrl();
    Long getShowtimeId();
    String getFilmTechnology();
    String getSubtitle();
    LocalDate getShowtimeDay();
    LocalTime getShowtimeTime();
    Long getCinemaRoomId();
    String getCinemaRoomName();
}
