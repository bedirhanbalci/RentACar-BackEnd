package com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCorporateCustomerRequest {

    @Positive(message = "Id must be a positive number!")
    private Integer id;

    @NotBlank(message = "Company Name cannot be blank!")
    private String companyName;

    @NotBlank(message = "Contact Name cannot be blank!")
    private String contactName;

    @NotBlank(message = "Contact Title cannot be blank!")
    private String contactTitle;

    @NotBlank(message = "Tax Number cannot be blank!")
    @Size(min = 10, message = "Tax Number must be at least 10 characters!")
    private String taxNumber;

    @Positive(message = "User Id must be a positive number!")
    private Integer userId;

}
