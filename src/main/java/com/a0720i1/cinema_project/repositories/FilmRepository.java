package com.a0720i1.cinema_project.repositories;

import com.a0720i1.cinema_project.models.dto.film.FilmDTO;
import com.a0720i1.cinema_project.models.dto.film.FilmDetailDTO;
import com.a0720i1.cinema_project.models.dto.film.FilmTopDTO;
import com.a0720i1.cinema_project.models.dto.film.TicketPriceDTO;
import com.a0720i1.cinema_project.models.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query(value = "select id, name, age, category, duration,start_date, imageurl, trailer\n" +
            "from film\n" +
            "where DATEDIFF(start_date, curdate()) > 6 or DATEDIFF(start_date, curdate()) = 6", nativeQuery = true)
    List<FilmDTO> listUpComingFilmDTO();

    @Query(value = "select id, name, age, category, duration,start_date, imageurl, trailer\n" +
            "from film\n" +
            "where not (DATEDIFF(start_date, curdate()) > 6 or DATEDIFF(start_date, curdate()) = 6)", nativeQuery = true)
    List<FilmDTO> listUpShowingFilmDTO();

    @Query(value = "select id, name, age, category, duration,start_date, imageurl, trailer\n" +
            "from film\n" +
            "where (DATEDIFF(start_date, curdate()) > 6 or DATEDIFF(start_date, curdate()) = 6) and film.name like %?1%", nativeQuery = true)
    List<FilmDTO> searchUpComingFilmDTO(String name);

    @Query(value = "select id, name, age, category, duration,start_date, imageurl, trailer\n" +
            "from film\n" +
            "where not (DATEDIFF(start_date, curdate()) > 6 or DATEDIFF(start_date, curdate()) = 6) and film.name like %?1%", nativeQuery = true)
    List<FilmDTO> searchUpShowingFilmDTO(String name);

    @Query(value = "select *\n" +
            "from film\n" +
            "where id = ?1", nativeQuery = true)
    FilmDetailDTO getFilmById(long id);

    @Query(value = "select * from ticket_price", nativeQuery = true)
    List<TicketPriceDTO> listTicketPrice();

    @Query(value = "select id, name, age, imageurl, trailer from film", nativeQuery = true)
    List<FilmTopDTO> getTopFilm();
}

