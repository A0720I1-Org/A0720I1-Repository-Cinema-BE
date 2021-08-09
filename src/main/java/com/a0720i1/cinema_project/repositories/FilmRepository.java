package com.a0720i1.cinema_project.repositories;

import com.a0720i1.cinema_project.models.dto.film.FilmViewDTO;
import com.a0720i1.cinema_project.models.dto.film.ListFilmDTO;
import com.a0720i1.cinema_project.models.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    /**
     * Duy
     */
    @Query(value = "select film.id, film.name as nameFilm, film.start_date as Start_date, film.studio, film.duration from film ", nativeQuery = true)
    Page<ListFilmDTO> getListFilm(Pageable pageable);

    /**
     * Duy
     */
    @Query(value = "select f.id, f.name, f.imageurl as imageURL, f.start_date as startDate, f.end_date as endDate, f.actors, f.studio, f.duration as durations, f.directors, f.category, f.description as descriptions, f.age, f.trailer as trailers, \n" +
            "s.film_technology as filmTechnology, s.sub_title as subTitle \n" +
            "from film as f\n" +
            "left join showtime as s on f.id = s.film_id\n" +
            "where f.id = ?1", nativeQuery = true)
    FilmViewDTO getFilmById(long id);

    /**
     * Duy
     */
    @Transactional
    @Modifying
    @Query(value = "update film as f set f.actors =?2, f.age =?3, f.category =?4 ,f.description =?5, f.directors =?6, f.duration=?7, f.imageUrl=?8, f.name=?9,  f.studio =?10, f.start_date = ?11, f.end_date =?12, f.trailer =?13\n" +
            "where f.id = ?1", nativeQuery = true)
    void updateFilm(long id, String actors, String age, String category, String description, String directors, int duration, String imageUrl, String name, String studio, LocalDate start_date, LocalDate end_date, String trailers);

    /**
     * Duy
     */
    @Transactional
    @Modifying
    @Query(value = "insert into film(actors, age, category, description, directors, duration, imageurl, name, studio, start_date, end_date, trailer) " +
            "values (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12)", nativeQuery = true)
    void createFilm(String actors,
                    String age, String category,
                    String descriptions, String directors,
                    int durations, String imageUrl, String name,
                    String studio, LocalDate start_date, LocalDate end_date, String trailers);

    /**
     * Duy
     */
    @Query(value = "select film.id, film.name as nameFilm, film.start_date as Start_date, film.studio, film.duration from `film` where film.name like %?1%", nativeQuery = true)
    Page<ListFilmDTO> searchByName(String name, Pageable pageable);

    /**
     * Duy
     */
    @Query(value = "select film.id, film.name as nameFilm, film.start_date as Start_date, film.studio, film.duration from `film` where film.name like %?1% and film.start_date like %?2%" , nativeQuery = true)
    Page<ListFilmDTO> searchByNameAndStartDate(String name, String startDate, Pageable pageable);

    /**
     * Duy
     */
    @Modifying
    @Transactional
    @Query(value = "delete from film where film.id = ?1", nativeQuery = true)
    void deleteFilm(long id);
}
