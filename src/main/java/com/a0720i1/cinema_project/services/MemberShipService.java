package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.dto.membership.MembershipDTO;
import com.a0720i1.cinema_project.models.dto.membership.MembershipEditDTO;
import com.a0720i1.cinema_project.models.entity.District;
import com.a0720i1.cinema_project.models.entity.Membership;
import com.a0720i1.cinema_project.models.entity.Province;
import com.a0720i1.cinema_project.models.entity.Ward;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface MemberShipService {
    Membership findById(long id);
    Page<MembershipDTO> findAll(Pageable pageable);
    void update(MembershipEditDTO membership);
    List<Province> findAllProvince();
    List<District> findAllDistrict(int provinceId);
    List<Ward> findAllWard(int districtId);
}
