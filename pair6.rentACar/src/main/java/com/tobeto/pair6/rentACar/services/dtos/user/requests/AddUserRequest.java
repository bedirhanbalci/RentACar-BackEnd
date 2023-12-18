package com.tobeto.pair6.rentACar.services.dtos.user.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {

    private String name;

    private String surname;

    @NotBlank(message = "Email boş olamaz!")
    @Email(message = "Email doğru formatta olmalıdır!")
    private String email;

    private LocalDate birthDate;

}
