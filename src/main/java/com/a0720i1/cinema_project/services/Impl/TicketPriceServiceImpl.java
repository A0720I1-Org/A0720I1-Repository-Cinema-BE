package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.models.entity.TicketPrice;
import com.a0720i1.cinema_project.repositories.TicketPriceRepository;
import com.a0720i1.cinema_project.services.TicketPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketPriceServiceImpl implements TicketPriceService {
    @Autowired
    TicketPriceRepository ticketPriceRepository;
    @Override
    public TicketPrice getTicketPriceBySeatCode(String seatCode) {
        return ticketPriceRepository.findAllBySeatCode(seatCode).get(0);
    }
}
