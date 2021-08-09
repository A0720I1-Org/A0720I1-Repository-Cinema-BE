package com.a0720i1.cinema_project.controllers;

import com.a0720i1.cinema_project.models.dto.showtime.CreateShowtimeDTO;
import com.a0720i1.cinema_project.models.dto.showtime.CreateShowtimeSeatDTO;
import com.a0720i1.cinema_project.models.dto.showtime.ShowTimeDataDTO;
import com.a0720i1.cinema_project.models.entity.CinemaRoom;
import com.a0720i1.cinema_project.models.entity.Film;
import com.a0720i1.cinema_project.models.entity.Showtime;

import com.a0720i1.cinema_project.services.ShowTimeService;
import com.a0720i1.cinema_project.services.TicketPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.a0720i1.cinema_project.models.dto.ticket.BookTicketShowtimeDto;
import com.a0720i1.cinema_project.models.dto.ticket.CinemaRoomLayout;
import com.a0720i1.cinema_project.models.dto.ticket.BookingSeatDTO;
import com.a0720i1.cinema_project.models.entity.PaymentMethod;
import com.a0720i1.cinema_project.services.PaymentMethodService;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.a0720i1.cinema_project.services.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RestController
public class ShowTimeController {
    @Autowired
    ShowTimeService showTimeService;

    @Autowired
    PaymentMethodService paymentMethodService;

    @Autowired
    TicketPriceService ticketPriceService;

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

    //vu
    @GetMapping("/api/admin/showtime/listFilm")
    public ResponseEntity<List<Film>> getAllFilm(){
        List<Film> films = showTimeService.findAllFilm();
        if (films.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(films,HttpStatus.OK);
    }

    @GetMapping("/api/admin/showtime/listCinemaRoom")
    public ResponseEntity<List<CinemaRoom>> getAllCinemaRoom(){
        List<CinemaRoom> cinemaRooms = showTimeService.findAllCinemaRoom();
        if (cinemaRooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cinemaRooms,HttpStatus.OK);
    }


    @PostMapping("/api/admin/showtime/create")
    @Transactional
    public ResponseEntity<?> createShowtime(@RequestBody ShowTimeDataDTO showtimeData) {
        for (CreateShowtimeDTO showtime : showtimeData.getShowtimeList()){
            this.showTimeService.createShowtimeDTO(showtime);
            Showtime createdShowtime = this.showTimeService.getShowtimeById(this.showTimeService.getMaxByIdShowtime());

            for (CreateShowtimeSeatDTO seat :showtimeData.getSeatList()) {
                Long ticketPriceId = ticketPriceService.getTicketPriceBySeatCode(seat.getCode()).getId();
                showTimeService.createSeat(seat.getName(), createdShowtime.getId(), ticketPriceId);
            }
//            get id cua showtime vua tao --------(ĐÃ CÓ SUẤT CHIẾU VỪA TẠO)
//            for trong cai showtimeData.getSeatList()  ---(ĐỂ LẤY CÁC GHẾ TRONG PHÒNG)
////          đã có showtimeId, seatName, seatCode (n,v,s)----(Lấy đc Phòng chiếu, chỗ ghế ngồi , mã ghế )
////          get ticket_price_id by seatCode ------(gắn giá tiền theo mã ghế(s,v))
////          tao seat voi 3 truong showtimeId, seatName, ticket_price_id (Tạo 1 ghế gồm các trường trên)
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
