package com.a0720i1.cinema_project.repositories;

import com.a0720i1.cinema_project.models.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {
}
