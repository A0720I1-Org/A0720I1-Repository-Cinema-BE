package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.dto.ticket.BookingInvoiceDTO;
import com.a0720i1.cinema_project.models.dto.ticket.InvoiceDTO;
import org.springframework.stereotype.Service;

@Service
public interface InvoiceService {
    long createInvoice(long membershipId, long paymentMethodId);
    BookingInvoiceDTO getInvoiceByInvoiceId(long invoiceId);
}
