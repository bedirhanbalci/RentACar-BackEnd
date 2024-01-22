package com.tobeto.pair6.rentACar.services.dtos.assurancePackage.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAssurancePackageRequest {

    private Integer id;

    private String name;

    private String detail;

    private Double dailyPrice;

}