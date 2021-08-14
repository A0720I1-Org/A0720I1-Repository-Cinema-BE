package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.dto.film.CreateFilmDTO;
import com.a0720i1.cinema_project.models.dto.film.UpdateFilmDTO;
import com.a0720i1.cinema_project.models.dto.film.FilmViewDTO;
import com.a0720i1.cinema_project.models.dto.film.ListFilmDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.a0720i1.cinema_project.models.dto.film.FilmDTO;
import com.a0720i1.cinema_project.models.dto.film.FilmDetailDTO;
import com.a0720i1.cinema_project.models.dto.film.FilmTopDTO;
import com.a0720i1.cinema_project.models.dto.film.TicketPriceDTO;

import java.util.List;

import org.springframework.stereotype.Service;

public interface FilmService {
    Page<ListFilmDTO> getListFilm(Pageable pageable);
    FilmViewDTO getFilmDTOById(long id);
    void updateFilm(UpdateFilmDTO updateFilmDTO);
    void createFilm(CreateFilmDTO createFilmDTO);
    void deleteFilm(long id);
    Page<ListFilmDTO> searchByName(String name, Pageable pageable);
    Page<ListFilmDTO> searchByNameAndStartDate(String name, String startDate, Pageable pageable);
    List<FilmDTO> listUpComingFilmDTO();

    List<FilmDTO> listUpShowingFilmDTO();

    List<FilmDTO> searchUpComingFilmDTO(String name);

    List<FilmDTO> searchUpShowingFilmDTO(String name);

    FilmDetailDTO getFilmById(long id);

    List<TicketPriceDTO> listTicketPrice();

    List<FilmTopDTO> getTopFilm();
}
