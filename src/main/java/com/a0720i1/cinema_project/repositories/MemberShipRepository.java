package com.a0720i1.cinema_project.repositories;
import com.a0720i1.cinema_project.models.dto.membership.MembershipDTO;
import com.a0720i1.cinema_project.models.entity.Membership;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;


@Repository
public interface MemberShipRepository extends JpaRepository<Membership, Long> {
    @Query(value = "select membership.id as id, membership.name as name, membership.card as card, membership.email as email, membership.phone as phone, district.name as districtName, ward.name as wardName, province.name as provinceName, membership.member_code as memberCode \n" +
            "from `membership` \n" +
            "left join ward on ward.id = membership.ward_id \n" +
            "left join district on district.id = ward.district_id \n" +
            "left join province on province.id = district.province_id", nativeQuery = true)
    Page<MembershipDTO> getAllMembership(Pageable pageable);
    @Transactional
    @Modifying
    @Query(value = "update membership as m set m.name = ?1,m.card = ?2,m.phone = ?3,m.email = ?4,m.birthday=?5,m.gender=?6,m.imageurl=?7,m.ward_id=?8 where m.id = ?9 ",
            nativeQuery = true)
    void updateMembership(String name, String card, String phone, String email, LocalDate birthday, String gender, String imageURL, Integer wardId, Long id);

}
