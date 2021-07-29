package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.models.dto.dto_cinemaroom.ListCinemaRoomDTO;
import com.a0720i1.cinema_project.models.entity.CinemaRoom;
import com.a0720i1.cinema_project.repositories.CinemaRoomRepository;
import com.a0720i1.cinema_project.services.CinemaRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaRoomServiceImpl implements CinemaRoomService {

    @Autowired
    private CinemaRoomRepository cinemaRoomRepository;

    @Override
    public Page<ListCinemaRoomDTO> listCinemaRoom(Pageable pageable) {
        return cinemaRoomRepository.listCinemaRoom(pageable);
    }

    @Override
    public Page<ListCinemaRoomDTO> searchByName(String name, Pageable pageable) {
        return cinemaRoomRepository.findCinemaRoomByNameLike(name.toUpperCase() ,pageable);
    }

    @Override
    public ListCinemaRoomDTO getCinemaRoomById(long id) {
        return cinemaRoomRepository.getCinemaRoomById(id);
    }

}
