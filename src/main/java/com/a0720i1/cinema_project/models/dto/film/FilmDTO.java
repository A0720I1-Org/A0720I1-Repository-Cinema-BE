package com.a0720i1.cinema_project.models.dto.film;

import java.time.LocalDate;

public interface FilmDTO {
    Long getId();
    String getName();
    String getAge();
    String getCategory();
    int getDuration();
    LocalDate getStart_date();
    String getImageUrl();
    String getTrailer();
}
