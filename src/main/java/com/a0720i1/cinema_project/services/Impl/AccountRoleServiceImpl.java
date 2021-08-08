package com.a0720i1.cinema_project.services.Impl;

<<<<<<< HEAD
=======
import com.a0720i1.cinema_project.models.entity.AccountRole;
>>>>>>> admin
import com.a0720i1.cinema_project.repositories.AccountRoleRepository;
import com.a0720i1.cinema_project.services.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> admin
@Service
public class AccountRoleServiceImpl implements AccountRoleService {
    @Autowired
    AccountRoleRepository accountRoleRepository;

<<<<<<< HEAD

    @Override
    public void createAccountRole(Long accountId, Long roleId) {
        accountRoleRepository.createAccountRole(accountId , roleId);
=======
    @Override
    public void createAccountRole(long accountId, long roleId) {
        accountRoleRepository.createAccountRole(accountId, roleId);
    }

    @Override
    public List<AccountRole> findAllByAccountUsername(String username) {
        return accountRoleRepository.findAllByAccountUsername(username);
>>>>>>> admin
    }
}
