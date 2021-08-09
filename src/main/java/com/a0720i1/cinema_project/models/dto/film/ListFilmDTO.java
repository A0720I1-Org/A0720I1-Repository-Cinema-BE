package com.a0720i1.cinema_project.models.dto.film;

import java.time.LocalDate;

public interface ListFilmDTO {
    int getId();
    String getNameFilm();
    LocalDate getStart_date();
    String getStudio();
    int getDuration();
}
