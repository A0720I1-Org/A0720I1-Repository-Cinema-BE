package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.dto.staff.EmployeeListDTO;
import com.a0720i1.cinema_project.dto.staff.EmployeeUpdateDTO;
import com.a0720i1.cinema_project.models.entity.District;
import com.a0720i1.cinema_project.models.entity.Employee;
import com.a0720i1.cinema_project.models.entity.Province;
import com.a0720i1.cinema_project.models.entity.Ward;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


public interface EmployeeService {

    Page<EmployeeListDTO> getPageAllStaff(Pageable pageable);

    void createStaffDto(String name, String card, LocalDate birthday, int wardId, String gender, String email, String phone, String imageUrl , int status , Long accountId);

    List<Ward> findAllByDistrictId(int districtId);
    List<District> findAllByProvinceId(int provinceId);
    List<Province> findAll();

    Employee findById(Long id);
    void deleteById(Long id);
    void update(EmployeeUpdateDTO employee);



}
