package com.tobeto.pair6.rentACar.services.dtos.user.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    private Integer id;

    private String email;

    private String password;

    private String phoneNumber;

    private String address;

    private String imagePath;

    private String companyName;

    private String contactName;

    private String contactTitle;

    private String taxNumber;

    private String firstName;

    private String lastName;

    private String nationalityNo;

    private LocalDate birthDate;

}
