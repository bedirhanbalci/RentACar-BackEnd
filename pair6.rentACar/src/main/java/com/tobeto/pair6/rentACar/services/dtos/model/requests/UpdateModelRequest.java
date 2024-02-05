package com.tobeto.pair6.rentACar.services.dtos.model.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateModelRequest {

    @Positive(message = "Id must be a positive number!")
    private Integer id;

    @NotBlank(message = "Model name cannot be blank!")
    @Size(min = 2, message = "Model name must be at least 2 characters!")
    private String name;

    @Positive(message = "Brand Id must be a positive number!")
    private Integer brandId;

}
