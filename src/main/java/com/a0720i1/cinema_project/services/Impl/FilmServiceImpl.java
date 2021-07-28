package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.dto.film.FilmDTO;
import com.a0720i1.cinema_project.repositories.FilmRepository;
import com.a0720i1.cinema_project.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<FilmDTO> listUpComingFilmDTO() {
        return this.filmRepository.listUpComingFilmDTO();
    }

    @Override
    public List<FilmDTO> listUpShowingFilmDTO() {
        return this.filmRepository.listUpShowingFilmDTO();
    }

    @Override
    public List<FilmDTO> searchUpComingFilmDTO(String name) {
        return this.filmRepository.searchUpComingFilmDTO(name);
    }

    @Override
    public List<FilmDTO> searchUpShowingFilmDTO(String name) {
        return this.filmRepository.searchUpShowingFilmDTO(name);
    }
}
