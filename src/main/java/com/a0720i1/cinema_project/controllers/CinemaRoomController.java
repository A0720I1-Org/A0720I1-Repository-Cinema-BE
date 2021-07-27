package com.a0720i1.cinema_project.controllers;

import com.a0720i1.cinema_project.models.dto.dto_cinemaroom.ListCinemaRoomDTO;
import com.a0720i1.cinema_project.models.entity.CinemaRoom;
import com.a0720i1.cinema_project.services.CinemaRoomService;
import com.a0720i1.cinema_project.services.Impl.CinemaRoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CinemaRoomController {
    @Autowired
    private CinemaRoomServiceImpl cinemaRoomService;

    @GetMapping("admin/cinema-room/list")
    public ResponseEntity<List<ListCinemaRoomDTO>> getAllListCinemaRoom() {
        List<ListCinemaRoomDTO> listCinemaRoomDTOS = cinemaRoomService.listCinemaRoom();
        if (listCinemaRoomDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listCinemaRoomDTOS, HttpStatus.OK);
        }
    }

    @GetMapping("admin/cinema-room/detail/{id}")
    public ResponseEntity<ListCinemaRoomDTO> getCinemaRoomById(@PathVariable Long id) {
        ListCinemaRoomDTO cinemaRoomById = cinemaRoomService.getCinemaRoomById(id);
        if (cinemaRoomById == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(cinemaRoomById, HttpStatus.OK);
        }
    }
}
