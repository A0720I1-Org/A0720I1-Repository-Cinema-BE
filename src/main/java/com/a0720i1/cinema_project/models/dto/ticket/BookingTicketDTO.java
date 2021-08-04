package com.a0720i1.cinema_project.models.dto.ticket;

public interface BookingTicketDTO {
    long getId();
    long getInvoiceId();
    long getSeatId();
    String getSeatName();
    String getSeatCode();
    String getSeatType();
    int getPrice();
}
