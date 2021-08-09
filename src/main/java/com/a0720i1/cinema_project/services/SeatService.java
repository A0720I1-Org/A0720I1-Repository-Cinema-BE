package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.entity.Seat;
import org.springframework.stereotype.Service;

@Service
public interface SeatService {
    void updateTicketIdBySeatId(long ticketId, long seatId);
    Seat findById(long seatId);
}
