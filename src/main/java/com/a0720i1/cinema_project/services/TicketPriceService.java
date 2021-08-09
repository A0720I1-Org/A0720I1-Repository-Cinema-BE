package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.entity.Seat;
import com.a0720i1.cinema_project.models.entity.TicketPrice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketPriceService {
    TicketPrice getTicketPriceBySeatCode(String seatCode);
}
