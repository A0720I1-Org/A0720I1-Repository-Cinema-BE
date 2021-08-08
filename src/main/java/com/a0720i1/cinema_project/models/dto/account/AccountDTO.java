package com.a0720i1.cinema_project.models.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private String newPassword;
    private String oldPassword;
    private String confirmPassword;
}
