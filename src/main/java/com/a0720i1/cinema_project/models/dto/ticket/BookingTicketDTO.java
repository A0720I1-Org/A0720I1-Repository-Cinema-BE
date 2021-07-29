package com.a0720i1.cinema_project.models.dto.ticket;

import lombok.Data;

@Data
public class BookingTicketDTO {
    private long id;
    private long invoiceId;
    private long seatId;
    private String seatName;
    private String seatCode;
    private String seatType;
    private int price;
}
