package com.a0720i1.cinema_project.controllers;
import com.a0720i1.cinema_project.dto.staff.EmployeeCreateDTO;
import com.a0720i1.cinema_project.dto.staff.EmployeeListDTO;
import com.a0720i1.cinema_project.dto.staff.EmployeeUpdateDTO;
import com.a0720i1.cinema_project.models.entity.*;
import com.a0720i1.cinema_project.services.AccountRoleService;
import com.a0720i1.cinema_project.services.AccountService;
import com.a0720i1.cinema_project.services.EmployeeService;
import com.a0720i1.cinema_project.services.Impl.EmployeeServiceImpl;
import com.a0720i1.cinema_project.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRoleService accountRoleService;
    @Autowired
    private RoleService roleService;
//    @Autowired
//    private BCryptPasswordEncoder encoder;


    @GetMapping("/admin/staffs/list")
    public ResponseEntity<Page<EmployeeListDTO>> getAllEmployeeList(@PageableDefault(value=5) Pageable pageable){
        Page<EmployeeListDTO> employeeList = this.employeeService.getPageAllStaff(pageable);
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @PostMapping(value="/admin/staffs/create-staff",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<?> createStaff(@RequestBody EmployeeCreateDTO employeeCreateDTO){
//        Map<String, String> listError = new HashMap<>();
//        if (accountService.getIdAccountByUsername(employeeCreateDTO.getUsername()) != null) {
//            listError.put("existUsername", "Tên đăng nhập đã tồn tại , vui lòng nhập Tên đăng nhập khác!");
//        }
//        if (!listError.isEmpty()) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(listError);
//        }
        accountService.createAccount(
                1,
//                encoder.encode(employeeCreateDTO.getPassword()),
                employeeCreateDTO.getPassword(),
                employeeCreateDTO.getUsername()
        );
        Long roleId = roleService.getIdRoleIdByRoleName("ROLE_EMPLOYEE");
        Long accountId = accountService.getIdAccountByUsername(employeeCreateDTO.getUsername());

        accountRoleService.createAccountRole(accountId , roleId);
        employeeService.createStaffDto(
                employeeCreateDTO.getName(),
                employeeCreateDTO.getCard(),
                employeeCreateDTO.getBirthday(),
                employeeCreateDTO.getWardId(),
                employeeCreateDTO.getGender() ,
                employeeCreateDTO.getEmail() ,
                employeeCreateDTO.getPhone(),
                employeeCreateDTO.getImageUrl(),
                1,
                accountId);
        return new ResponseEntity<>(HttpStatus.CREATED);


    }

    @GetMapping("/api/public/ward")
    public ResponseEntity<List<Ward>> findWardByDistrictId(@RequestParam(value = "districtId",required = false) Integer districtId) {
        if(districtId == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(employeeService.findAllByDistrictId(districtId));

    }
    @GetMapping("/api/public/district")
    public ResponseEntity<List<District>> findDistrictByDistrictId(@RequestParam(value = "provinceId",required = false) Integer provinceId) {
        if(provinceId == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(employeeService.findAllByProvinceId(provinceId));
    }
    @GetMapping("/api/public/province")
    public ResponseEntity<List<Province>> findProvince() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @DeleteMapping("/api/public/employee/{id}")
    public ResponseEntity<?> deleteByEmployeeId(@PathVariable Long id) {
        if(id == null){
            return ResponseEntity.badRequest().body("Không có nhân viên này !");
        }
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/api/public/employee/{id}")
    public ResponseEntity<?> getByEmployeeId(@PathVariable Long id) {
        if(id == null){
            return ResponseEntity.badRequest().body("Không có nhân viên này !");
        }
        return new ResponseEntity<>(employeeService.findById(id),HttpStatus.OK);
    }

    @PutMapping("/api/public/employee")
    public ResponseEntity<?> update(@RequestBody EmployeeUpdateDTO employee) {
        employeeService.update(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
