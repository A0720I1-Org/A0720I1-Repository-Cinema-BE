package com.a0720i1.cinema_project.services;

import org.springframework.stereotype.Service;

@Service
public interface AccountRoleService{
    void createAccountRole(Long  accountId , Long roleId);
}
