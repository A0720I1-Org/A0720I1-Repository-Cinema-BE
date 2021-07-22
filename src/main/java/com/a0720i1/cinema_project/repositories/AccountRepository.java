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

    @Query(value = "select id from account where username = ?1 limit 1", nativeQuery = true)
    int findIdUserByUsername(String username);

    @Modifying
    @Query(value = "insert into account(username, password, is_enabled) values (?1, ?2, ?3)", nativeQuery = true)
    void add(String username, String password, int isEnable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE account SET password = ?1 WHERE username = ?2", nativeQuery = true)
    void changePassword(String encodePw, String username);
}


