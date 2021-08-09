package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.models.entity.Seat;
import com.a0720i1.cinema_project.repositories.SeatRepository;
import com.a0720i1.cinema_project.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    SeatRepository seatRepository;
    @Override
    public void updateTicketIdBySeatId(long ticketId, long seatId) {
        seatRepository.updateTicketIdBySeatId(ticketId, seatId);
    }

    @Override
    public Seat findById(long seatId) {
        return seatRepository.findById(seatId).orElse(null);
    }
}
