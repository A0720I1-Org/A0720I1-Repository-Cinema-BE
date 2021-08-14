package com.a0720i1.cinema_project.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isEnable;
    @JsonBackReference
    @OneToMany(mappedBy = "account")
    private List<AccountRole> accountRoleList;

    public Account(long id, String username, String password, boolean isEnable, List<AccountRole> accountRoleList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isEnable = isEnable;
        this.accountRoleList = accountRoleList;
    }
}
