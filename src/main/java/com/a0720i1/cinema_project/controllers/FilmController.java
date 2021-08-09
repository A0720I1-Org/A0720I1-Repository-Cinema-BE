package com.a0720i1.cinema_project.controllers;

import com.a0720i1.cinema_project.models.dto.film.CreateFilmDTO;
import com.a0720i1.cinema_project.models.dto.film.UpdateFilmDTO;
import com.a0720i1.cinema_project.models.dto.film.FilmViewDTO;
import com.a0720i1.cinema_project.models.dto.film.ListFilmDTO;
import com.a0720i1.cinema_project.services.Impl.FilmServiceImpl;
import com.a0720i1.cinema_project.validation.FilmCreateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class FilmController {
    @Autowired
    private FilmServiceImpl filmService;

    @Autowired
    private FilmCreateValidator filmCreateValidator;

    @GetMapping("/api/admin/film/list")
    public ResponseEntity<Page<ListFilmDTO>> getListFilm(@PageableDefault(size = 8) Pageable pageable) {
        Page<ListFilmDTO> listFilmDTOS = this.filmService.getListFilm(pageable);
        if (listFilmDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listFilmDTOS, HttpStatus.OK);
    }

    @GetMapping("/api/admin/film/find/{id}")
    public ResponseEntity<FilmViewDTO> getFilmById(@PathVariable long id) {
        FilmViewDTO filmViewDTO = this.filmService.getFilmById(id);
        if (filmViewDTO == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(filmViewDTO, HttpStatus.OK);
    }

    @PutMapping("/api/admin/film/update")
    public ResponseEntity<UpdateFilmDTO> updateFilm(@RequestBody UpdateFilmDTO filmUpdateDTO) {
        this.filmService.updateFilm(filmUpdateDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/admin/film/create")
    @Transactional
    public ResponseEntity<?> createFilm(@Valid @RequestBody CreateFilmDTO createFilmDTO, BindingResult bindingResult) throws MethodArgumentNotValidException {
        filmCreateValidator.validate(createFilmDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResult);
        }
        filmService.createFilm(createFilmDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/admin/film/search")
    public ResponseEntity<Page<ListFilmDTO>> getListSearchByName(@PageableDefault(size = 8) Pageable pageable,
                                                                 @RequestParam String name) {
        Page<ListFilmDTO> listSearchFilm = filmService.searchByName(name, pageable);
        if (listSearchFilm.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listSearchFilm, HttpStatus.OK);
        }
    }

    @DeleteMapping("/admin/film/delete/{id}")
    public ResponseEntity<?> deleteFilm(@PathVariable long id) {
        this.filmService.deleteFilm(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
