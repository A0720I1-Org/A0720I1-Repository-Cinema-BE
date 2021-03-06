package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.models.dto.ticket.*;
import com.a0720i1.cinema_project.models.entity.Invoice;
import com.a0720i1.cinema_project.repositories.InvoiceRepository;
import com.a0720i1.cinema_project.repositories.MemberShipRepository;
import com.a0720i1.cinema_project.repositories.PaymentMethodRepository;
import com.a0720i1.cinema_project.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    MemberShipRepository memberShipRepository;

    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public Invoice createInvoice(long membershipId, long paymentMethodId, String code) {
        Invoice invoice = new Invoice();
        invoice.setMembership(memberShipRepository.getById(membershipId));
        invoice.setPaymentMethod(paymentMethodRepository.getById(paymentMethodId));
        invoice.setCode(code);
        invoice = invoiceRepository.save(invoice);
        return invoice;
    }

    @Override
    public BookingInvoiceDTO getInvoiceByInvoiceId(long invoiceId) {
        return invoiceRepository.getInvoiceByInvoiceId(invoiceId);
    }

    @Override
    public void sendEmail(String email, String invoiceCode, BookTicketShowtimeDto showtime, List<BookingTicketDTO> ticketList) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> seatNameList = new ArrayList<>();
        int amount = 0;
        for (BookingTicketDTO ticket: ticketList){
            seatNameList.add(ticket.getSeatName());
            amount += ticket.getPrice();
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("A0720I1 Cinema - Th??ng tin ?????t v??");
        message.setText("Ch??o Qu?? kh??ch!\n"
                + "A0720I1 Cinema xin ch??n th??nh c???m ??n qu?? kh??ch ???? l???a ch???n d???ch v??? c???a ch??ng t??i.\n"
                + "Th??ng tin ?????t v??: \n\n"
                + "M?? ?????t v??: " + invoiceCode + "\n"
                + "T??n phim: " + showtime.getFilmName() + "\n"
                + "R???p: " + showtime.getCinemaRoomName() + "\n"
                + "Ng??y chi???u: " + showtime.getShowtimeDay() + "\n"
                + "Su???t chi???u: " + showtime.getShowtimeTime() + "\n"
                + "Gh???: " + String.join(", ", seatNameList) + "\n"
                + "T???ng c???ng: " + amount + "\n"
                + "Qu?? kh??ch vui l??ng ????a m?? ?????t v?? ?????n qu???y v?? ????? nh???n v??" + "\n\n"
                + "Tr??n tr???ng!");
        this.emailSender.send(message);
    }

    @Override
    public String generateCode() {
        int number1 = (int) Math.floor(1000 + Math.random() * 9000);
        int number2 = (int) Math.floor(1000 + Math.random() * 9000);
        int number3 = (int) Math.floor(1000 + Math.random() * 9000);
        int number4 = (int) Math.floor(1000 + Math.random() * 9000);
        return number1+"-"+number2+"-"+number3+"-"+number4;
    }
}
