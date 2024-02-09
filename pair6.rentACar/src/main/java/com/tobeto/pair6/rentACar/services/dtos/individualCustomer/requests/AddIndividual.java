package com.tobeto.pair6.rentACar.services.dtos.individualCustomer.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddIndividual {

    @NotBlank(message = "First Name cannot be blank!")
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank!")
    private String lastName;

    @Size(min = 11, max = 11, message = "Nationality No must be 11 characters!")
    private String nationalityNo;

    private LocalDate birthDate;

    @NotBlank(message = "Email cannot be blank!")
    @Email(message = "Invalid email format!")
    private String email;

    @NotBlank(message = "Password cannot be blank!")
    private String password;

    @NotBlank(message = "Phone Number cannot be blank!")
    private String phoneNumber;

}
