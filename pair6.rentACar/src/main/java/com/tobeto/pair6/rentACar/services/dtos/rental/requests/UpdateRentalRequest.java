package com.tobeto.pair6.rentACar.services.dtos.rental.requests;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {

    @Positive(message = "Id must be a positive number!")
    private Integer id;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate returnDate;

    @Positive(message = "End Kilometer must be a positive number!")
    private Integer endKilometer;

    @Positive(message = "Car Id must be a positive number!")
    private Integer carId;

    @Positive(message = "User Id must be a positive number!")
    private Integer userId;

    @Positive(message = "Assurance Package Id must be a positive number!")
    private Integer assurancePackageId;

    @Positive(message = "Additional Feature Id must be a positive number!")
    private Integer additionalFeatureId;

}
