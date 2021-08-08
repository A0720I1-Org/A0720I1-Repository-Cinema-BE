package com.a0720i1.cinema_project.models.dto.ticket;

import com.a0720i1.cinema_project.models.entity.PaymentMethod;
import lombok.Data;

import java.util.List;

@Data
public class BookingInformation {
    private long showtimeId;
    private long memberId;
    private List<Long> seatIdList;
    private BookTicketShowtimeDto showtime;
    private long paymentMethodId;
}
