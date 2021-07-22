package com.a0720i1.cinema_project.repositories;

import com.a0720i1.cinema_project.models.entity.AccountRole;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AccountRoleRepository {
    // Đôn: Thêm mới role cho tài khoản
    @Transactional
    @Modifying
    @Query(value = "insert into account_role(account_id, role_id) values (?1, ?2)", nativeQuery = true)
    void createAccountRole(int accountId, int roleId);

    List<AccountRole> findAllByAccountUsername(String account_username);
}
