package com.tobeto.pair6.rentACar.services.dtos.car.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCarRequest {
    private int id;
    private int kilometer;
    private String plate;
    private int year;
    private double dailyPrice;
    private int modelId;
    private int colorId;
}
