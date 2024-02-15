package com.tobeto.pair6.rentACar.services.dtos.individualCustomer.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateIndividualCustomerRequest {

    @Positive(message = "Id must be a positive number!")
    private Integer id;

    @NotBlank(message = "First Name cannot be blank!")
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank!")
    private String lastName;

    @Size(min = 11, max = 11, message = "Nationality No must be 11 characters!")
    private String nationalityNo;

    private LocalDate birthDate;

    @Positive(message = "User Id must be a positive number!")
    private Integer userId;

}
