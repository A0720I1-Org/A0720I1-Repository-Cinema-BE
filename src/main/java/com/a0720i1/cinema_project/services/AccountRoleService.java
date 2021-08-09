package com.a0720i1.cinema_project.services;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

@Service
public interface AccountRoleService{
    void createAccountRole(Long  accountId , Long roleId);
=======
import com.a0720i1.cinema_project.models.entity.AccountRole;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AccountRoleService  {
    void createAccountRole(long accountId, long roleId);
    List<AccountRole> findAllByAccountUsername(String username);
>>>>>>> admin
}
