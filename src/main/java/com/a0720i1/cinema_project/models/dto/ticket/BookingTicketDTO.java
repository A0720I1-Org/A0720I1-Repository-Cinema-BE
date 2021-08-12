package com.a0720i1.cinema_project.models.dto.ticket;

public interface BookingTicketDTO {
    String getCode();
    Long getId();
    Long getInvoiceId();
    Long getSeatId();
    String getSeatName();
    String getSeatCode();
    String getSeatType();
    Integer getPrice();
}
