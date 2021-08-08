package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.dto.film.FilmDTO;
import com.a0720i1.cinema_project.models.dto.film.FilmDetailDTO;
import com.a0720i1.cinema_project.models.dto.film.FilmTopDTO;
import com.a0720i1.cinema_project.models.dto.film.TicketPriceDTO;

import java.util.List;

public interface FilmService {
    List<FilmDTO> listUpComingFilmDTO();
    List<FilmDTO> listUpShowingFilmDTO();
    List<FilmDTO> searchUpComingFilmDTO(String name);
    List<FilmDTO> searchUpShowingFilmDTO(String name);
    FilmDetailDTO getFilmById(long id);
    List<TicketPriceDTO> listTicketPrice();
    List<FilmTopDTO> getTopFilm();
}
