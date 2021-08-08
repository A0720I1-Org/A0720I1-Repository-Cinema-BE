package com.a0720i1.cinema_project.repositories;

import com.a0720i1.cinema_project.models.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface ShowTimeRepository extends JpaRepository<Showtime,Long> {
//    @Query(value = "select showtime.id as id, showtime.day as day,showtime.film_technology as filmTechnology,showtime.sub_title as subtitle,\n" +
//            "showtime.time as time,film.name as nameFilm,cinema_room.name as nameCinemaRoom\n" +
//            " from showtime\n" +
//            " left join cinema_room on cinema_room.id=showtime.cinema_room_id\n" +
//            " left join film on film.id=showtime.film_id \n"+
//            "where showtime.id=?1",nativeQuery = true)
//    ListShowTimeDTO getShowtimeById(long id);

    @Transactional
    @Modifying
    @Query(value = "insert into showtime(film_technology, sub_title, day , time,film_id ,cinema_room_id) values (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void createShowtimeDTO( String filmTechnology,
            String subTitle,
            LocalDate day,
            LocalTime time,
            Long filmId,
            Long cinemaRoomId);

    @Query(value = "select max(id) from showtime",nativeQuery = true)
    Long getMaxIdShowtime();
}
