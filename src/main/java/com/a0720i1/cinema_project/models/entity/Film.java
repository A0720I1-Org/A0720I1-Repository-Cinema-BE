package com.a0720i1.cinema_project.models.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String imageURL;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDate;
    private String actors;
    private String studio;
    private int duration;
    private String directors;
    private String category;
    @Lob
    private String description;
    @Lob
    private String age;
    private String trailer;

    @JsonBackReference
    @OneToMany(mappedBy = "film")
    private List<Showtime> showtimeList;

}

