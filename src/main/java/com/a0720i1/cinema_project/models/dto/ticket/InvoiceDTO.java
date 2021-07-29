package com.a0720i1.cinema_project.models.dto.ticket;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class InvoiceDTO {
    private long id;
    private long memberId;
    private String memberCode;
    private String memberName;
    private String memberEmail;
    private String memberPhone;
    private List<BookingTicketDTO> ticketList = new ArrayList<>();
    private BookTicketShowtimeDto showtime;
    private String paymentMethod;
}
