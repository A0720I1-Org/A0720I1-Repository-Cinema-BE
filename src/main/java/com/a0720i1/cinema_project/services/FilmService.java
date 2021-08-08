package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.dto.film.CreateFilmDTO;
import com.a0720i1.cinema_project.models.dto.film.UpdateFilmDTO;
import com.a0720i1.cinema_project.models.dto.film.FilmViewDTO;
import com.a0720i1.cinema_project.models.dto.film.ListFilmDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface FilmService {
    Page<ListFilmDTO> getListFilm(Pageable pageable);
    FilmViewDTO getFilmById(long id);
    void updateFilm(UpdateFilmDTO updateFilmDTO);
    void createFilm(CreateFilmDTO createFilmDTO);
    void deleteFilm(long id);
    Page<ListFilmDTO> searchByName(String name, Pageable pageable);
    Page<ListFilmDTO> searchByNameAndStartDate(String name, String startDate, Pageable pageable);
}
