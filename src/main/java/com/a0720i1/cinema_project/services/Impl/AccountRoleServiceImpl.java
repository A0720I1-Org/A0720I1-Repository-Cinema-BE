package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.repositories.AccountRoleRepository;
import com.a0720i1.cinema_project.services.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountRoleServiceImpl implements AccountRoleService {
    @Autowired
    AccountRoleRepository accountRoleRepository;


    @Override
    public void createAccountRole(Long accountId, Long roleId) {
        accountRoleRepository.createAccountRole(accountId , roleId);
    }
}
