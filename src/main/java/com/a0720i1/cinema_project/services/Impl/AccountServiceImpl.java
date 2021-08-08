package com.a0720i1.cinema_project.services.Impl;


import com.a0720i1.cinema_project.repositories.AccountRepository;
import com.a0720i1.cinema_project.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;


    @Override
    public void createAccount(int isEnable, String password, String username) {
        accountRepository.createAccount(isEnable , password , username);
    }

    @Override
    public Long getIdAccountByUsername(String username) {
        return accountRepository.getIdAccountByUsername(username);
    }
}
