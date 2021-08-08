package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.models.entity.District;
import com.a0720i1.cinema_project.repositories.DistrictRepository;
import com.a0720i1.cinema_project.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    DistrictRepository districtRepository;
    @Override
    public List<District> findAllByProvinceId(int provinceId) {
        return districtRepository.findAllByProvinceId(provinceId);
    }
}
