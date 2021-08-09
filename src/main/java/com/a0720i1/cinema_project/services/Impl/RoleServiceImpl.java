package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.repositories.RoleRepository;
import com.a0720i1.cinema_project.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Long getIdRoleIdByRoleName(String roleName) {
        return roleRepository.getIdRoleIdByRoleName(roleName) ;
    }
}
