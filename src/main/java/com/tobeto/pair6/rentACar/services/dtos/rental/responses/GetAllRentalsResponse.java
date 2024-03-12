package com.tobeto.pair6.rentACar.services.dtos.rental.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllRentalsResponse {

    private Integer id;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate returnDate;

    private Integer startKilometer;

    private Integer endKilometer;

    private Double totalPrice;

    private Double discountRate;

    private Double generalPrice;

    private String carPlate;

    private String userEmail;

    private String assurancePackageName;

    private String additionalFeatureName;

}
