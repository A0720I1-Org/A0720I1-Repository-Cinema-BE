package com.a0720i1.cinema_project.controllers;

import com.a0720i1.cinema_project.models.dto.showtime.CreateShowtimeDTO;
import com.a0720i1.cinema_project.models.dto.showtime.CreateShowtimeSeatDTO;
import com.a0720i1.cinema_project.models.dto.showtime.ShowTimeDataDTO;
import com.a0720i1.cinema_project.models.entity.CinemaRoom;
import com.a0720i1.cinema_project.models.entity.Film;
import com.a0720i1.cinema_project.models.entity.Showtime;
import com.a0720i1.cinema_project.services.CinemaRoomService;
import com.a0720i1.cinema_project.services.FilmService;
import com.a0720i1.cinema_project.services.ShowTimeService;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShowTimeController {
    @Autowired
    private ShowTimeService showTimeService;





//    @GetMapping("admin/showtime/detail/{id}")
//    public ResponseEntity<ListShowTimeDTO> getShowtimeById(@PathVariable Long id) {
//        ListShowTimeDTO showtime = showTimeService.getShowtimeById(id);
//        if (showtime == null) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(showtime, HttpStatus.OK);
//        }
//    }

    @GetMapping("api/admin/showtime/listFilm")
    public ResponseEntity<List<Film>> getAllFilm(){
        List<Film> films = showTimeService.findAllFilm();
        if (films.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(films,HttpStatus.OK);
    }

    @GetMapping("api/admin/showtime/listCinemaRoom")
    public ResponseEntity<List<CinemaRoom>> getAllCinemaRoom(){
        List<CinemaRoom> cinemaRooms = showTimeService.findAllCinemaRoom();
        if (cinemaRooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cinemaRooms,HttpStatus.OK);
    }


    @PostMapping("admin/showtime/create")
    @Transactional
    public ResponseEntity<?> createShowtime(@RequestBody ShowTimeDataDTO showtimeData) {
        for (CreateShowtimeDTO showtime : showtimeData.getShowtimeList()){
            this.showTimeService.createShowtimeDTO(showtime);
            Showtime showtime1 = this.showTimeService.getShowtimeById(this.showTimeService.getMaxByIdShowtime());

            for (CreateShowtimeSeatDTO createShowtimeSeatDTO:showtimeData.getSeatList()) {

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
