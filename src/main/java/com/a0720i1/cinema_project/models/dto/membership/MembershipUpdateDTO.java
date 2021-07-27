package com.a0720i1.cinema_project.models.dto.membership;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MembershipUpdateDTO {
    Long id;
    String name;
    String card;
    String phone;
    String email;
    LocalDate birthday;
    String gender;
    String imageURL;
    Integer wardId;
}
