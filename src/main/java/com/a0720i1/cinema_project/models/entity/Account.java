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
@AllArgsConstructor
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


}
