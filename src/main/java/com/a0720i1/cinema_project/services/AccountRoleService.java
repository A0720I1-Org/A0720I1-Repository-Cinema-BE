package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.entity.AccountRole;

import java.util.List;

public interface AccountRoleService  {
    void createAccountRole(int accountId, int roleId);
    List<AccountRole> findAllByAccountUsername(String username);
}
