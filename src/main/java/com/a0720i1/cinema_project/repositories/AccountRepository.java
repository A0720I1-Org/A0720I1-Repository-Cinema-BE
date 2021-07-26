package com.a0720i1.cinema_project.repositories;


import com.a0720i1.cinema_project.models.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findAccountByUsername(String username);
    @Transactional
    @Modifying
    @Query(value = "insert into account(username, password, is_enable) values (?1, ?2, 1)", nativeQuery = true)
    void createAccount(String username, String password);

    @Transactional
    @Modifying
    @Query(value = "UPDATE account SET password = ?1 WHERE username = ?2", nativeQuery = true)
    void changePassword(String encodePw, String username);
}


