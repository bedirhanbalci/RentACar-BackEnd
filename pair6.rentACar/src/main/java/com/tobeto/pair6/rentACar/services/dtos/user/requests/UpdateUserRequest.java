package com.tobeto.pair6.rentACar.services.dtos.user.requests;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    @Positive(message = "Doğru Id girişi yapınız!")
    private int id;

    private String name;

    private String surname;

    private String email;

    private LocalDate birthDate;
}
