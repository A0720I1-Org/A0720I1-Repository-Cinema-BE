package com.a0720i1.cinema_project.repositories;

import com.a0720i1.cinema_project.dto.staff.EmployeeListDTO;
import com.a0720i1.cinema_project.models.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account , Long> {
    @Modifying
    @Query(value = "INSERT INTO `movie`.`account` (`is_enable`, `password`, `username`) VALUES (?1, ?2 , ?3)", nativeQuery = true)
    void createAccount(int isEnable , String  password , String username);

    @Query(value = "select account.id from account where account.username = ?1 limit 1", nativeQuery = true)
    Long getIdAccountByUsername(String username);

}
