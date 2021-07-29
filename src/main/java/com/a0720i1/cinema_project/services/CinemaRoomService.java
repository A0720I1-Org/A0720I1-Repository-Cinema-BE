package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.dto.dto_cinemaroom.ListCinemaRoomDTO;
import com.a0720i1.cinema_project.models.entity.CinemaRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CinemaRoomService {
    Page<ListCinemaRoomDTO> listCinemaRoom(Pageable pageable);
    Page<ListCinemaRoomDTO> searchByName(String name,Pageable pageable);

    ListCinemaRoomDTO getCinemaRoomById(long id);
}
