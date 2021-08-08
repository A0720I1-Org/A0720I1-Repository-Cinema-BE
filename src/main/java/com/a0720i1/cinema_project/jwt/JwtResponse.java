package com.a0720i1.cinema_project.jwt;

import com.a0720i1.cinema_project.models.entity.Account;
import com.a0720i1.cinema_project.models.entity.Membership;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Account account;
    private Membership membership;
    private List<String> roles;

    public JwtResponse(String token, Account account, List<String> roles) {
        this.token = token;
        this.account = account;
        this.roles = roles;
    }

    public JwtResponse(String token, Account account, Membership membership, List<String> roles) {
        this.token = token;
        this.account = account;
        this.membership = membership;
        this.roles = roles;
    }

    public JwtResponse(String token) {
        this.token = token;
    }

    public JwtResponse(String token,  List<String> roles) {
        this.token = token;
        this.roles = roles;
    }
}
