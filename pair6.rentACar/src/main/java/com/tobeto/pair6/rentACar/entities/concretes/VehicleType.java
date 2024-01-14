package com.tobeto.pair6.rentACar.entities.concretes;

import lombok.Getter;

@Getter
public enum VehicleType {

    SEDAN("Sedan"),

    SUV("Suv"),

    HATCHBACK("Hatchback"),

    TRUCK("Truck"),

    CROSSOVER("Crossover"),

    MINIVAN("Minivan"),

    SPORTS("Sports");

    private final String vehicleType;

    VehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
