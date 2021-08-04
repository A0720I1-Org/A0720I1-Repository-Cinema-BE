package com.a0720i1.cinema_project.models.dto.ticket;

import lombok.Data;

@Data
public class InvoiceDTO {
    private long id;
    private long memberId;
    private String memberCode;
    private String memberName;
    private String memberEmail;
    private String memberPhone;
    private String paymentMethod;
}
