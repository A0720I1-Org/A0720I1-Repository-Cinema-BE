package com.a0720i1.cinema_project.repositories;

import com.a0720i1.cinema_project.models.entity.Seat;
import com.a0720i1.cinema_project.models.entity.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketPriceRepository extends JpaRepository<TicketPrice, Long> {
    List<TicketPrice> findAllBySeatCode(String seatCode);
}
