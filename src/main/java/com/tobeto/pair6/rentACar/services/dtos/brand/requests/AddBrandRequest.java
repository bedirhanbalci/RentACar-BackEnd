package com.tobeto.pair6.rentACar.services.dtos.brand.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBrandRequest {

    @NotBlank(message = "Brand name cannot be blank!")
    @Size(min = 2, message = "Brand name must be at least 2 characters!")
    private String name;

}
