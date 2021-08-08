package com.a0720i1.cinema_project.models.dto.ticket;

public interface CinemaRoomLayout {
    Long getCinemaRoomId();
    Integer getRowSeat();
    Integer getColumnSeat();
    String getSeatLayout();
}
