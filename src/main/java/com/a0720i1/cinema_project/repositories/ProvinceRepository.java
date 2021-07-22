package com.a0720i1.cinema_project.repositories;

import com.a0720i1.cinema_project.models.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository<Province,Integer> {
    List<Province> findAll();
}
