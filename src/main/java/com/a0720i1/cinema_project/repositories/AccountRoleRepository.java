package com.a0720i1.cinema_project.repositories;

import com.a0720i1.cinema_project.models.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRoleRepository extends JpaRepository<AccountRole , Long > {
    @Modifying
    @Query(value = "INSERT INTO `movie`.`account_role` (`account_id`, `role_id`) VALUES (?1, ?2)", nativeQuery = true)
    void createAccountRole(Long  accountId , Long roleId);

}
