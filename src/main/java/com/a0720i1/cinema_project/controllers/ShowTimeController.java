package com.a0720i1.cinema_project.controllers;

import com.a0720i1.cinema_project.models.dto.ticket.BookTicketShowtimeDto;
import com.a0720i1.cinema_project.models.dto.ticket.CinemaRoomLayout;
import com.a0720i1.cinema_project.models.dto.ticket.BookingSeatDTO;
import com.a0720i1.cinema_project.models.entity.PaymentMethod;
import com.a0720i1.cinema_project.services.PaymentMethodService;
import com.a0720i1.cinema_project.services.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ShowTimeController {
    @Autowired
    ShowTimeService showTimeService;

    @Autowired
    PaymentMethodService paymentMethodService;
    @GetMapping(value = "/api/public/showtime/get-showtime-showing")
    public ResponseEntity<?> getAllFilmShowingThisWeek(){
        List<BookTicketShowtimeDto> showtimeList = showTimeService.getAllFilmShowingThisWeek();
        if (showtimeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(showtimeList,HttpStatus.OK);
    }
    @GetMapping("/api/public/showtime/get-seat-of-showtime")
    public ResponseEntity<List<BookingSeatDTO>> getAllSeatByShowtimeId(@RequestParam long showtimeId){
        List<BookingSeatDTO> seatList = this.showTimeService.getAllSeatByShowtimeId(showtimeId);
        if (seatList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(seatList, HttpStatus.OK);
    }

    @GetMapping("/api/public/showtime/get-cinema-room-layout")
    public ResponseEntity<CinemaRoomLayout> getCinemaRoomLayoutByShowtimeId(@RequestParam long showtimeId){
        CinemaRoomLayout layout = this.showTimeService.getCinemaRoomLayoutByShowtimeId(showtimeId);
        if (layout == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(layout, HttpStatus.OK);
    }
    @GetMapping("/api/public/showtime/get-payment-method-list")
    public ResponseEntity<List<PaymentMethod>> getPaymentMethodList(){
        List<PaymentMethod> methodList = paymentMethodService.getAllPaymentMethod();
        if (methodList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(methodList, HttpStatus.OK);
    }

    @GetMapping("/api/member/showtime/get-showtime-by-invoice-id")
    public ResponseEntity<BookTicketShowtimeDto> getShowtimeByInvoiceId(@RequestParam long invoiceId){
        BookTicketShowtimeDto showtime = showTimeService.getShowtimeByInvoiceId(invoiceId);
        if (showtime == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(showtime, HttpStatus.OK);
    }
}
