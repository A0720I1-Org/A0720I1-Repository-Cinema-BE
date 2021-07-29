package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.models.dto.ticket.BookingInvoiceDTO;
import com.a0720i1.cinema_project.models.dto.ticket.InvoiceDTO;
import com.a0720i1.cinema_project.models.entity.Invoice;
import com.a0720i1.cinema_project.repositories.InvoiceRepository;
import com.a0720i1.cinema_project.repositories.MemberShipRepository;
import com.a0720i1.cinema_project.repositories.PaymentMethodRepository;
import com.a0720i1.cinema_project.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    MemberShipRepository memberShipRepository;

    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Override
    public long createInvoice(long membershipId, long paymentMethodId) {
        Invoice invoice = new Invoice();
        invoice.setMembership(memberShipRepository.getById(membershipId));
        invoice.setPaymentMethod(paymentMethodRepository.getById(paymentMethodId));
        invoice = invoiceRepository.save(invoice);
        return invoice.getId();
    }

    @Override
    public BookingInvoiceDTO getInvoiceByInvoiceId(long invoiceId) {
        return invoiceRepository.getInvoiceByInvoiceId(invoiceId);
    }
}
