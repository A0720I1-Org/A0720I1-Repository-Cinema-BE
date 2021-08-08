package com.a0720i1.cinema_project.models.dto.film;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateFilmDTO {
    String name;
    String imageURL;
    LocalDate startDate;
    LocalDate endDate;
    String actors;
    String studio;
    int duration;
    String directors;
    String trailers;
    String category;
    String description;
    String age;
}
