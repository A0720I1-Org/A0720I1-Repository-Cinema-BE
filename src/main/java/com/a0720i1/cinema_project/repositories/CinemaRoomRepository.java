package com.a0720i1.cinema_project.repositories;

import com.a0720i1.cinema_project.models.dto.dto_cinemaroom.ListCinemaRoomDTO;
import com.a0720i1.cinema_project.models.entity.CinemaRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRoomRepository extends JpaRepository<CinemaRoom,Long> {

    @Query(value = "select cinema_room.id as id,cinema_room.name as name,cinema_room.row_seat as rowSeat " +
            ",cinema_room.column_seat as columnSeat,cinema_room.status as status, cinema_room.seat_layout as seatLayout \n" +
            "from cinema_room ",nativeQuery = true)
    Page<ListCinemaRoomDTO> listCinemaRoom(Pageable pageable);

    @Query(value = "select cinema_room.id as id,cinema_room.name as name,cinema_room.row_seat as rowSeat " +
            ",cinema_room.column_seat as columnSeat,cinema_room.status as status, cinema_room.seat_layout as seatLayout \n" +
            "from cinema_room \n"+
            "where id=?1",nativeQuery = true)
    ListCinemaRoomDTO getCinemaRoomById(long id);

    @Query(value = "select cinema_room.id as id,cinema_room.name as name,cinema_room.row_seat as rowSeat" +
            ",cinema_room.column_seat as columnSeat,cinema_room.status as status, cinema_room.seat_layout as seatLayout \n" +
            "from cinema_room\n" +
            "where cinema_room.name like %?1%",nativeQuery = true)
    Page<ListCinemaRoomDTO> findCinemaRoomByNameLike(String name,Pageable pageable);
}
