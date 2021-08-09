package com.a0720i1.cinema_project.models.dto.ticket;

import java.util.ArrayList;
import java.util.List;

public interface BookingInvoiceDTO {
    Long getId();
    String getCode();
    Long getMemberId();
    String getMemberCode();
    String getMemberName();
    String getMemberEmail();
    String getMemberPhone();
    String getPaymentMethod();
}
