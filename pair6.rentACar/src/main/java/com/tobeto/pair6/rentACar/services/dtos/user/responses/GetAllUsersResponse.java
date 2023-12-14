package com.tobeto.pair6.rentACar.services.dtos.user.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUsersResponse {

    private String name;

    private String surname;

    private String email;

    private LocalDate birthDate;
}
