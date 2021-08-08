package com.a0720i1.cinema_project.services;

import com.a0720i1.cinema_project.models.dto.account.AccountDTO;
import com.a0720i1.cinema_project.models.entity.Account;

public interface AccountService {
<<<<<<< HEAD

    void createAccount(int isEnable , String  password , String username);

    Long getIdAccountByUsername(String username);
=======
    Account findByUsername(String username);
    void createAccount(String username, String password);
    boolean checkChangePassword(Account account,AccountDTO accountDTO);
    boolean checkNewPwEqualOldPw(Account account,AccountDTO accountDTO);
    void changePassword(Account account,AccountDTO accountDTO);
    String generateCode();
    void sendEmailOTP(String email, String code);
    void changePasswordByForgot(String password,Account account);
>>>>>>> admin
}
