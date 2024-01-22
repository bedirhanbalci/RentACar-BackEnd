package com.tobeto.pair6.rentACar.services.dtos.additionalFeature.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAdditionalFeatureRequest {

    private String name;

    private String detail;

    private Double dailyPrice;

    private Integer quantity;

}
