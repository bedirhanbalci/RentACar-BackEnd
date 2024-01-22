package com.tobeto.pair6.rentACar.entities.concretes;

import lombok.Getter;

@Getter
public enum BodyType {

    SEDAN("Sedan"),

    SUV("Suv"),

    HATCHBACK("Hatchback"),

    CROSSOVER("Crossover"),

    SPORTS("Sports");

    private final String bodyType;

    BodyType(String bodyType) {
        this.bodyType = bodyType;
    }

}
