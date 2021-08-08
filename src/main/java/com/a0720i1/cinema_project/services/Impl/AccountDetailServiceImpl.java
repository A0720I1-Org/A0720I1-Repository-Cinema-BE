package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.models.entity.Account;
import com.a0720i1.cinema_project.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountDetailServiceImpl implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByUsername(username);
        if (account == null){
            throw new UsernameNotFoundException("User " + username + "was not found in the database");
        }
        return AccountDetailsImpl.build(account);
    }
}
