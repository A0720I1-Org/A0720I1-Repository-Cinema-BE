package com.a0720i1.cinema_project.services;

import org.springframework.stereotype.Service;

@Service
public interface SeatService {
    void updateTicketIdBySeatId(long ticketId, long seatId);
}