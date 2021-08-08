package com.a0720i1.cinema_project.models.dto.ticket;

public class PaymentDTO {
    private Double amount;

    public PaymentDTO() {
    }

    public PaymentDTO(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
