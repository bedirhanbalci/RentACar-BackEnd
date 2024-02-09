package com.tobeto.pair6.rentACar.services.dtos.car.responses;

import com.tobeto.pair6.rentACar.entities.concretes.BodyType;
import com.tobeto.pair6.rentACar.entities.concretes.FuelType;
import com.tobeto.pair6.rentACar.entities.concretes.GearType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCarResponse {

    private Integer id;

    private Integer kilometer;

    private String plate;

    private Integer year;

    private Double dailyPrice;

    private String imagePath;

    private GearType gearType;

    private FuelType fuelType;

    private BodyType bodyType;

    private String modelName;

    private String brandName;

    private String colorName;

    private String branchCity;

}
