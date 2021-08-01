package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.models.entity.Province;
import com.a0720i1.cinema_project.repositories.ProvinceRepository;
import com.a0720i1.cinema_project.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;
    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }
}
