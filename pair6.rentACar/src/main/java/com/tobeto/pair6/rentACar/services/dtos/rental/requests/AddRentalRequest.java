package com.tobeto.pair6.rentACar.services.dtos.rental.requests;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalRequest {

    private LocalDate startDate;

    private LocalDate endDate;

    @Positive(message = "Car Id must be a positive number!")
    private Integer carId;

    @Positive(message = "User Id must be a positive number!")
    private Integer userId;

    @Positive(message = "Assurance Package Id must be a positive number!")
    private Integer assurancePackageId;

    private List<Object> additionalList;

    @Positive(message = "Additional Feature Id must be a positive number!")
    private Integer additionalFeatureId;

}
