package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.dto.dto_cinemaroom.ListCinemaRoomDTO;
import com.a0720i1.cinema_project.models.entity.CinemaRoom;

import java.util.List;

public interface CinemaRoomService {
    List<ListCinemaRoomDTO> listCinemaRoom();

    ListCinemaRoomDTO getCinemaRoomById(long id);
}
