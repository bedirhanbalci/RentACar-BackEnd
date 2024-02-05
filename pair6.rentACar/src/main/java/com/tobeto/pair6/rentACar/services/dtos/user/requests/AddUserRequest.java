package com.tobeto.pair6.rentACar.services.dtos.user.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {

    @NotBlank(message = "Email cannot be blank!")
    @Email(message = "Invalid email format!")
    private String email;

    @NotBlank(message = "Password cannot be blank!")
    private String password;

    @NotBlank(message = "Phone Number cannot be blank!")
    private String phoneNumber;

    @NotBlank(message = "Address cannot be blank!")
    private String address;

    private String imagePath;

}
