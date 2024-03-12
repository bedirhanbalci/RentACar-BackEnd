package com.tobeto.pair6.rentACar.entities.concretes;

import lombok.Getter;

@Getter
public enum FuelType {

    PETROL("Petrol"),

    DIESEL("Diesel"),

    ELECTRIC("Electric"),

    HYBRID("Hybrid");

    private final String fuelType;

    FuelType(String fuelType) {
        this.fuelType = fuelType;
    }

}
