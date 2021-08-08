package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.models.dto.film.FilmDTO;
import com.a0720i1.cinema_project.models.dto.film.FilmDetailDTO;
import com.a0720i1.cinema_project.models.dto.film.FilmTopDTO;
import com.a0720i1.cinema_project.models.dto.film.TicketPriceDTO;
import com.a0720i1.cinema_project.models.entity.Film;
import com.a0720i1.cinema_project.repositories.FilmRepository;
import com.a0720i1.cinema_project.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    @Override
    public FilmDetailDTO getFilmById(long id) {
        return this.filmRepository.getFilmById(id);
    }

    @Override
    public List<TicketPriceDTO> listTicketPrice() {
        return this.filmRepository.listTicketPrice();
    }

    @Override
    public List<FilmTopDTO> getTopFilm() {
        Random rand = new Random();
        List<FilmTopDTO> newListFilm = new ArrayList<>();
        List<FilmTopDTO> listFilm = this.filmRepository.getTopFilm();
        int index = 3;
        for (int i = 0; i < index; i++) {
            int randomIndex = rand.nextInt(listFilm.size());
            newListFilm.add(listFilm.get(randomIndex));
            listFilm.remove(randomIndex);
        }
        return newListFilm;
    }
}
