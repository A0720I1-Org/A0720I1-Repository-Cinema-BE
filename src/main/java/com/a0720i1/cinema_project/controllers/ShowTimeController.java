package com.a0720i1.cinema_project.controllers;

import com.a0720i1.cinema_project.common.ShowtimeNotAvailableException;
import com.a0720i1.cinema_project.models.dto.film.FilmDTO;
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
        List<Film> films = showTimeService.getAllFilmAvailable();
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
    public ResponseEntity<?> createShowtime(@RequestBody ShowTimeDataDTO showtimeData) throws ShowtimeNotAvailableException {
        for (CreateShowtimeDTO showtime : showtimeData.getShowtimeList()){
            if (showTimeService.checkShowtimeAvailable(showtime.getCinemaRoomId(), showtime.getDay(), showtime.getTime()).isEmpty()){
                this.showTimeService.createShowtimeDTO(showtime);
                Showtime createdShowtime = this.showTimeService.getShowtimeById(this.showTimeService.getMaxByIdShowtime());

                for (CreateShowtimeSeatDTO seat :showtimeData.getSeatList()) {
                    Long ticketPriceId = ticketPriceService.getTicketPriceBySeatCode(seat.getCode()).getId();
                    showTimeService.createSeat(seat.getName(), createdShowtime.getId(), ticketPriceId);
                }
            } else {
                throw new ShowtimeNotAvailableException("???? c?? su???t chi???u v??o l??c " + showtime.getTime() +
                        ", ng??y " + showtime.getDay().getDayOfMonth() + "-" + showtime.getDay().getMonthValue() + "-" + showtime.getDay().getYear());
            }

//            get id cua showtime vua tao --------(???? C?? SU???T CHI???U V???A T???O)
//            for trong cai showtimeData.getSeatList()  ---(????? L???Y C??C GH??? TRONG PH??NG)
////          ???? c?? showtimeId, seatName, seatCode (n,v,s)----(L???y ??c Ph??ng chi???u, ch??? gh??? ng???i , m?? gh??? )
////          get ticket_price_id by seatCode ------(g???n gi?? ti???n theo m?? gh???(s,v))
////          tao seat voi 3 truong showtimeId, seatName, ticket_price_id (T???o 1 gh??? g???m c??c tr?????ng tr??n)
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
