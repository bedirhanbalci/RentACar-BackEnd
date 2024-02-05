package com.tobeto.pair6.rentACar.services.dtos.branch.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBranchRequest {

    @NotBlank(message = "City cannot be blank!")
    private String city;

    @NotBlank(message = "Address cannot be blank!")
    private String address;

    @NotBlank(message = "Phone Number cannot be blank!")
    private String phoneNumber;

    private Double latitude;

    private Double longitude;

}
