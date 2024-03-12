package com.tobeto.pair6.rentACar.services.dtos.brand.requests;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteBrandRequest {

    @Positive(message = "Id must be a positive number!")
    private Integer id;

}
