package com.a0720i1.cinema_project.services.Impl;
import com.a0720i1.cinema_project.models.dto.membership.MembershipDTO;
import com.a0720i1.cinema_project.models.dto.membership.MembershipEditDTO;
import com.a0720i1.cinema_project.models.entity.District;
import com.a0720i1.cinema_project.models.entity.Membership;
import com.a0720i1.cinema_project.models.entity.Province;
import com.a0720i1.cinema_project.models.entity.Ward;
import com.a0720i1.cinema_project.repositories.DistrictRepository;
import com.a0720i1.cinema_project.repositories.MemberShipRepository;
import com.a0720i1.cinema_project.repositories.ProvinceRepository;
import com.a0720i1.cinema_project.repositories.WardRepository;
import com.a0720i1.cinema_project.services.MemberShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberShipServiceImpl implements MemberShipService {
    @Autowired
    MemberShipRepository memberShipRepository;
    @Autowired
    ProvinceRepository provinceRepository;
    @Autowired
    DistrictRepository districtRepository;
    @Autowired
    WardRepository wardRepository;


    @Override
    public Membership findById(long id) {
        return memberShipRepository.findById(id).orElse(null);
    }

    @Override
    public Page<MembershipDTO> findAll(Pageable pageable) {
        return memberShipRepository.getAllMembership(pageable);
    }

    @Override
    public void update(MembershipEditDTO membership) {
        memberShipRepository.updateMembership(membership.getName()
                ,membership.getCard().replaceAll("\\s{2,}", " ").trim()
                ,membership.getPhone()
                ,membership.getEmail()
                ,membership.getBirthday()
                ,membership.getGender()
                ,membership.getImageURL()
                ,membership.getWardId()
                ,membership.getId());
    }

    @Override
    public List<Province> findAllProvince() {
        return provinceRepository.findAll();
    }

    @Override
    public List<District> findAllDistrict(int provinceId) {
        return districtRepository.findAllByProvinceId(provinceId);
    }

    @Override
    public List<Ward> findAllWard(int districtId) {
        return wardRepository.findAllByDistrictId(districtId);
    }


}
