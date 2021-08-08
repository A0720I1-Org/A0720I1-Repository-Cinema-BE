package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.dto.ticket.*;
import com.a0720i1.cinema_project.models.entity.Invoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvoiceService {
    Invoice createInvoice(long membershipId, long paymentMethodId, String code);
    BookingInvoiceDTO getInvoiceByInvoiceId(long invoiceId);
    void sendEmail(String email, String invoiceCode, BookTicketShowtimeDto showtime, List<BookingTicketDTO> ticketList);
    String generateCode();
}
