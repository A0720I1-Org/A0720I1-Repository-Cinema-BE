package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.models.entity.AccountRole;
import com.a0720i1.cinema_project.repositories.AccountRoleRepository;
import com.a0720i1.cinema_project.services.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountRoleServiceImpl implements AccountRoleService {
    @Autowired
    AccountRoleRepository accountRoleRepository;

    @Override
    public void createAccountRole(long accountId, long roleId) {
        accountRoleRepository.createAccountRole(accountId, roleId);
    }

    @Override
    public List<AccountRole> findAllByAccountUsername(String username) {
        return accountRoleRepository.findAllByAccountUsername(username);
    }
}
