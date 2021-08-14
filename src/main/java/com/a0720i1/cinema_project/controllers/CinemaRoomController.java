package com.a0720i1.cinema_project.controllers;

import com.a0720i1.cinema_project.models.dto.dto_cinemaroom.ListCinemaRoomDTO;
import com.a0720i1.cinema_project.services.Impl.CinemaRoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CinemaRoomController {
    @Autowired
    private CinemaRoomServiceImpl cinemaRoomService;

    @GetMapping("/api/admin/cinema-room/list")
    public ResponseEntity<Page<ListCinemaRoomDTO>> getAllListCinemaRoom(@PageableDefault(size = 7)Pageable pageable) {
        Page<ListCinemaRoomDTO> listCinemaRoomDTOS = cinemaRoomService.listCinemaRoom(pageable);
        if (listCinemaRoomDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listCinemaRoomDTOS, HttpStatus.OK);
        }
    }
    @GetMapping("/api/admin/cinema-room/search")
    public ResponseEntity<Page<ListCinemaRoomDTO>> getListSearchByName(@PageableDefault(size = 7) Pageable pageable,
                                                                        @RequestParam String name) {
        Page<ListCinemaRoomDTO> listSearchCinemaRoom = cinemaRoomService.searchByName(name,pageable);

        if (listSearchCinemaRoom.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listSearchCinemaRoom, HttpStatus.OK);
        }
    }

    @GetMapping("/api/admin/cinema-room/detail/{id}")
    public ResponseEntity<ListCinemaRoomDTO> getCinemaRoomById(@PathVariable Long id) {
        ListCinemaRoomDTO cinemaRoomById = cinemaRoomService.getCinemaRoomById(id);
        if (cinemaRoomById == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(cinemaRoomById, HttpStatus.OK);
        }
    }

}
