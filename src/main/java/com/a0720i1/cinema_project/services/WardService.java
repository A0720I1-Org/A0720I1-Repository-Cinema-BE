package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.entity.Ward;

import java.util.List;

public interface WardService {
    List<Ward> findAllByDistrictId(int districtId);
}
