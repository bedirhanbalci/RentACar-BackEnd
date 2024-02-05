package com.tobeto.pair6.rentACar.services.dtos.color.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateColorRequest {

    @Positive(message = "Id must be a positive number!")
    private Integer id;

    @NotBlank(message = "Color name cannot be blank!")
    @Size(min=2, message = "Color name must be at least 2 characters!")
    private String name;

}
