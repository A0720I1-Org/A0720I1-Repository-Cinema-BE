package com.a0720i1.cinema_project.services;

public interface AccountService {

    void createAccount(int isEnable , String  password , String username);

    Long getIdAccountByUsername(String username);
}
