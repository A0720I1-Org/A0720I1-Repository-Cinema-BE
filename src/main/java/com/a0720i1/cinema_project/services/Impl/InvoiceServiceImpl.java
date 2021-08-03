package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.models.dto.ticket.*;
import com.a0720i1.cinema_project.models.entity.Invoice;
import com.a0720i1.cinema_project.repositories.InvoiceRepository;
import com.a0720i1.cinema_project.repositories.MemberShipRepository;
import com.a0720i1.cinema_project.repositories.PaymentMethodRepository;
import com.a0720i1.cinema_project.services.InvoiceService;
import org.apache.http.util.TextUtils;
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

    @Override
    public void sendEmail(String email, long invoiceId, BookTicketShowtimeDto showtime, List<TicketDTO> ticketList) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> seatNameList = new ArrayList<>();
        int amount = 0;
        for (TicketDTO ticket: ticketList){
            seatNameList.add(ticket.getSeatName());
            amount += ticket.getPrice();
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("A0720I1 Cinema - Thông tin đặt vé");
        message.setText("Chào bạn!\n"
                + "A0720I1 Cinema xin chân thành cảm ơn quý khách đã lựa chọn dịch vụ của chúng tôi.\n"
                + "Thông tin đặt vé: \n\n"
                + "Mã đặt vé: " + invoiceId + "\n"
                + "Tên phim: " + showtime.getFilmName() + "\n"
                + "Rạp: " + showtime.getCinemaRoomName() + "\n"
                + "Ngày chiếu: " + showtime.getShowtimeDay() + "\n"
                + "Suất chiếu: " + showtime.getShowtimeTime() + "\n"
                + "Ghế: " + String.join(", ", seatNameList) + "\n"
                + "Tổng cộng: " + amount + "\n"
                + "Quý khách vui lòng đưa mã đặt vé đến quầy vé để nhận vé" + "\n\n"
                + "Trân trọng!");
        this.emailSender.send(message);
    }
}
