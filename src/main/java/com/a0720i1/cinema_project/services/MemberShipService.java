package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.entity.Membership;

import java.util.List;

public interface MemberShipService {
    void save(Membership membership);
    Membership findById(int id);
    List<Membership> fillAll();
}
