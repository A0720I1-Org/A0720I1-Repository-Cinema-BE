package com.a0720i1.cinema_project.repositories;

import com.a0720i1.cinema_project.models.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WardRepository extends JpaRepository<Ward,Integer> {
    List<Ward> findAllByDistrictId(int districtId);
}
