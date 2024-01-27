package com.tobeto.pair6.rentACar.services.dtos.color.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdColorResponse {

    private Integer id;

    private String name;

}
