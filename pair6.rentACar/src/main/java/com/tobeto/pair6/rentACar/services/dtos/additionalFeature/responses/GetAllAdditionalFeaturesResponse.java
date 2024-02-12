package com.tobeto.pair6.rentACar.services.dtos.additionalFeature.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAdditionalFeaturesResponse {

    private Integer id;

    private String name;

    private String detail;

    private Double dailyPrice;

    private Integer quantity;

    private String imagePath;

}
