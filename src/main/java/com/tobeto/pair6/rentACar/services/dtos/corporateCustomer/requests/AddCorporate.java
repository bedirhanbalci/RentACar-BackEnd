package com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCorporate {

    @NotBlank(message = "Company Name cannot be blank!")
    private String companyName;

    @NotBlank(message = "Contact Name cannot be blank!")
    private String contactName;

    @NotBlank(message = "Contact Title cannot be blank!")
    private String contactTitle;

    @NotBlank(message = "Tax Number cannot be blank!")
    @Size(min = 10, message = "Tax Number must be at least 10 characters!")
    private String taxNumber;

    @NotBlank(message = "Email cannot be blank!")
    @Email(message = "Invalid email format!")
    private String email;

    @NotBlank(message = "Password cannot be blank!")
    private String password;

    @NotBlank(message = "Phone Number cannot be blank!")
    private String phoneNumber;

}
