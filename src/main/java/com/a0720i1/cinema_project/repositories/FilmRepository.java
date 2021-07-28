package com.a0720i1.cinema_project.repositories;

import com.a0720i1.cinema_project.dto.film.FilmDTO;
import com.a0720i1.cinema_project.models.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query(value = "select id, name, age, category, duration,start_date, imageurl\n" +
            "from film\n" +
            "where DATEDIFF(start_date, curdate()) > 6 or DATEDIFF(start_date, curdate()) = 6", nativeQuery = true)
    List<FilmDTO> listUpComingFilmDTO();

    @Query(value = "select id, name, age, category, duration,start_date, imageurl\n" +
            "from film\n" +
            "where not (DATEDIFF(start_date, curdate()) > 6 or DATEDIFF(start_date, curdate()) = 6)", nativeQuery = true)
    List<FilmDTO> listUpShowingFilmDTO();

    @Query(value = "select id, name, age, category, duration,start_date, imageurl\n" +
            "from film\n" +
            "where (DATEDIFF(start_date, curdate()) > 6 or DATEDIFF(start_date, curdate()) = 6) and film.name like %?1%", nativeQuery = true)
    List<FilmDTO> searchUpComingFilmDTO(String name);

    @Query(value = "select id, name, age, category, duration,start_date, imageurl\n" +
            "from film\n" +
            "where not (DATEDIFF(start_date, curdate()) > 6 or DATEDIFF(start_date, curdate()) = 6) and film.name like %?1%", nativeQuery = true)
    List<FilmDTO> searchUpShowingFilmDTO(String name);
}