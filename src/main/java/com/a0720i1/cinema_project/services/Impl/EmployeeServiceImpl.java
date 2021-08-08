package com.a0720i1.cinema_project.services.Impl;


import com.a0720i1.cinema_project.dto.staff.EmployeeListDTO;
import com.a0720i1.cinema_project.dto.staff.EmployeeUpdateDTO;
import com.a0720i1.cinema_project.models.entity.District;
import com.a0720i1.cinema_project.models.entity.Employee;
import com.a0720i1.cinema_project.models.entity.Province;
import com.a0720i1.cinema_project.models.entity.Ward;
import com.a0720i1.cinema_project.repositories.DistrictRepository;
import com.a0720i1.cinema_project.repositories.EmployeeRepository;
import com.a0720i1.cinema_project.repositories.ProvinceRepository;
import com.a0720i1.cinema_project.repositories.WardRepository;
import com.a0720i1.cinema_project.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private WardRepository wardRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Page<EmployeeListDTO> getPageAllStaff(Pageable pageable) {
        return employeeRepository.getPageAllStaff(pageable);
    }

    @Override
    public void createStaffDto(String name, String card, LocalDate birthday, int wardId, String gender, String email, String phone, String imageUrl , int status , Long accountId) {
        employeeRepository.createStaffDto(name, card , birthday , wardId , gender , email , phone , imageUrl , status , accountId);
    }

    @Override
    public List<Ward> findAllByDistrictId(int districtId) {
        return wardRepository.findAllByDistrictId(districtId);
    }

    @Override
    public List<District> findAllByProvinceId(int provinceId) {
        return districtRepository.findAllByProvinceId(provinceId);
    }

    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }

    @Override
    public void update(EmployeeUpdateDTO employee) {
        employeeRepository.updateEmployee(employee.getName()
                ,employee.getCard().replaceAll("\\s{2,}", " ").trim()
                ,employee.getPhone()
                ,employee.getEmail()
                ,employee.getBirthday()
                ,employee.getGender()
                ,employee.getImageURL()
                ,employee.getWardId()
                ,employee.getId());
    }


}
