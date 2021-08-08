package com.a0720i1.cinema_project.services.Impl;

import com.a0720i1.cinema_project.models.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetailsImpl implements UserDetails {
    private long id;
    private String username;
    private String password;
    private boolean isEnable;
    private List<GrantedAuthority> authorities;
    public AccountDetailsImpl(long id, String username, String password, List<GrantedAuthority> authorities, boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.isEnable = enabled;
    }
    public static AccountDetailsImpl build(Account account) {
        List<GrantedAuthority> authorities = account.getAccountRoleList().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole().getName()))
                .collect(Collectors.toList());
        return new AccountDetailsImpl(
                account.getId(),
                account.getUsername(),
                account.getPassword(),
                authorities,
                account.isEnable()
        );
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        AccountDetailsImpl account = (AccountDetailsImpl) obj;
        return account.getId() == this.id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
