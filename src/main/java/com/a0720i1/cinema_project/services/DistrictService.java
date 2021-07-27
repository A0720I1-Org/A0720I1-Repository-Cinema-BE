package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.entity.District;

import java.util.List;

public interface DistrictService {
    List<District> findAllByProvinceId(int provinceId);
}
