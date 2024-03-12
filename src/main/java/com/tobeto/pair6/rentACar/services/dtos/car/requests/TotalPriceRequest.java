package com.tobeto.pair6.rentACar.services.dtos.car.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalPriceRequest {

    private Integer carId;

    private LocalDate startDate;

    private LocalDate endDate;

}
