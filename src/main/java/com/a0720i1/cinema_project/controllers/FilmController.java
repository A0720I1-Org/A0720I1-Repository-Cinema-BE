package com.a0720i1.cinema_project.controllers;

import com.a0720i1.cinema_project.models.dto.film.FilmDTO;
import com.a0720i1.cinema_project.models.dto.film.FilmDetailDTO;
import com.a0720i1.cinema_project.models.dto.film.FilmTopDTO;
import com.a0720i1.cinema_project.models.dto.film.TicketPriceDTO;
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

    @GetMapping("/api/public/film/film")
    public FilmDetailDTO getFilmById(@RequestParam long id) {
        return this.filmService.getFilmById(id);
    }

    @GetMapping("/api/public/ticket-price/list-ticket-price")
    public List<TicketPriceDTO> listTicketPrice() {
        return this.filmService.listTicketPrice();
    }

    @GetMapping("/api/public/film/top-film")
    public List<FilmTopDTO> getTopFilm() {
        return this.filmService.getTopFilm();
    }
}
