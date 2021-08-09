package com.a0720i1.cinema_project.models.dto.showtime;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CreateShowtimeDTO {
    String filmTechnology;
    String subTitle;
    LocalDate day;
    LocalTime time;
    Long filmId;
    Long cinemaRoomId;

}
