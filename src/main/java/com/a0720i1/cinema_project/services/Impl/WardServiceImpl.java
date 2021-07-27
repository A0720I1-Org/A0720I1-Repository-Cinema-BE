package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.models.entity.Ward;
import com.a0720i1.cinema_project.repositories.DistrictRepository;
import com.a0720i1.cinema_project.repositories.WardRepository;
import com.a0720i1.cinema_project.services.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WardServiceImpl implements WardService {
    @Autowired
    DistrictRepository districtRepository;
    @Autowired
    WardRepository wardRepository;
    @Override
    public List<Ward> findAllByDistrictId(int districtId) {
        return wardRepository.findAllByDistrictId(districtId);
    }
}
