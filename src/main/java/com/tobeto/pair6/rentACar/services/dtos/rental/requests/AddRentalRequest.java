package com.tobeto.pair6.rentACar.services.dtos.rental.requests;

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

    private Integer carId;

    private Integer userId;

    private Integer assurancePackageId;

    private List<AdditionalModel> additionalList;

    private Integer additionalFeatureId;

}
