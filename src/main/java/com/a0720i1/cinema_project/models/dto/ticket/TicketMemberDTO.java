package com.a0720i1.cinema_project.models.dto.ticket;

import java.time.LocalDate;
import java.time.LocalTime;

public interface TicketMemberDTO {
    Long getInvoiceId();
    String getMemberCode();
    String getMemberName();
    String getMemberCard();
    String getMemberPhone();
    String getFilmName();
    LocalDate getDay();
    LocalTime getTime();
    Long getPrinted();
}
