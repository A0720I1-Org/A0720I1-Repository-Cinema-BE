package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.dto.film.FilmDTO;

import java.util.List;

public interface FilmService {
    List<FilmDTO> listUpComingFilmDTO();
    List<FilmDTO> listUpShowingFilmDTO();
    List<FilmDTO> searchUpComingFilmDTO(String name);
    List<FilmDTO> searchUpShowingFilmDTO(String name);
}
