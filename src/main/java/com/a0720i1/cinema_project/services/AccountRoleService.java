package com.a0720i1.cinema_project.services;

import org.springframework.stereotype.Service;
import com.a0720i1.cinema_project.models.entity.AccountRole;

import java.util.List;

@Service
public interface AccountRoleService{
//    void createAccountRole(Long  accountId , Long roleId);

    void createAccountRole(long accountId, long roleId);
    List<AccountRole> findAllByAccountUsername(String username);
}
