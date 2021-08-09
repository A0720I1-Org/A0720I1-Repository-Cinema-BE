package com.a0720i1.cinema_project.models.dto.dto_cinemaroom;


import org.hibernate.annotations.Type;

public interface ListCinemaRoomDTO {
    long getId();
    String getName();
    Integer getRowSeat();
    Integer getColumnSeat();
    Integer getStatus();
    String getSeatLayout();
}
