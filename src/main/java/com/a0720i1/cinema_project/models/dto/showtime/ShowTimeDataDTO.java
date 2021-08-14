package com.a0720i1.cinema_project.models.dto.showtime;

import lombok.Data;

import java.util.List;
@Data
public class ShowTimeDataDTO {
    List<CreateShowtimeDTO> showtimeList;
    List<CreateShowtimeSeatDTO> seatList;
}
