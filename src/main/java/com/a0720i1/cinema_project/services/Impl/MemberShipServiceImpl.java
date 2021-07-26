package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.models.entity.Membership;
import com.a0720i1.cinema_project.repositories.MemberShipRepository;
import com.a0720i1.cinema_project.services.MemberShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberShipServiceImpl implements MemberShipService {
    @Autowired
    MemberShipRepository memberShipRepository;
    @Override
    public void save(Membership membership) {
        memberShipRepository.save(membership);
    }

    @Override
    public Membership findById(int id) {
        return memberShipRepository.findById(id).orElse(null);
    }

    @Override
    public List<Membership> fillAll() {
        return memberShipRepository.findAll();
    }
}
