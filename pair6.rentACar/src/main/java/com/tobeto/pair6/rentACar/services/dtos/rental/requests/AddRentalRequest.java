package com.tobeto.pair6.rentACar.services.dtos.rental.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalRequest {

    @NotNull(message = "Start Date must not be null!")
    private LocalDate startDate;

    @NotNull(message = "End Date must not be null!")
    private LocalDate endDate;

    @Positive(message = "Car Id must be a positive number!")
    private Integer carId;

    @Positive(message = "User Id must be a positive number!")
    private Integer userId;

    @Positive(message = "Assurance Package Id must be a positive number!")
    private Integer assurancePackageId;

    @Positive(message = "Additional Feature Id must be a positive number!")
    private Integer additionalFeatureId;

}
