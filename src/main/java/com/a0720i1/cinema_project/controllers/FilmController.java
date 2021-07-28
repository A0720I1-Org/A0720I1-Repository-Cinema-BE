package com.a0720i1.cinema_project.controllers;

import com.a0720i1.cinema_project.dto.film.FilmDTO;
import com.a0720i1.cinema_project.services.Impl.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilmController {
    @Autowired
    private FilmServiceImpl filmService;

    @GetMapping("/api/public/film/listUpComingFilm")
    public List<FilmDTO> listUpComingFilmDTO() {
        return this.filmService.listUpComingFilmDTO();
    }

    @GetMapping("/api/public/film/listUpShowingFilm")
    public List<FilmDTO> listUpShowingFilmDTO() {
        return this.filmService.listUpShowingFilmDTO();
    }

    @GetMapping("/api/public/film/coming")
    public List<FilmDTO> searchUpComingFilmDTO(@RequestParam String name) {
        return this.filmService.searchUpComingFilmDTO(name);
    }

    @GetMapping("/api/public/film/showing")
    public List<FilmDTO> searchUpShowingFilmDTO(@RequestParam String name) {
        return this.filmService.searchUpShowingFilmDTO(name);
    }
}
