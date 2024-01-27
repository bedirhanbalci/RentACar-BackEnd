package com.tobeto.pair6.rentACar.services.dtos.model.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdModelResponse {

    private Integer id;

    private String name;

    private String brandName;

}
