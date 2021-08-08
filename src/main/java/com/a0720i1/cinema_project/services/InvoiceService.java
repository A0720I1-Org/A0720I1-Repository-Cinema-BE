package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.dto.ticket.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvoiceService {
    long createInvoice(long membershipId, long paymentMethodId);
    BookingInvoiceDTO getInvoiceByInvoiceId(long invoiceId);
    void sendEmail(String email, long invoiceId, BookTicketShowtimeDto showtime, List<BookingTicketDTO> ticketList);
}
