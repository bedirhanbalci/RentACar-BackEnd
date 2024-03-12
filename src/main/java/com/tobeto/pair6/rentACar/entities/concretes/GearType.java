package com.tobeto.pair6.rentACar.entities.concretes;

import lombok.Getter;

@Getter
public enum GearType {

    MANUAL("Manual"),

    AUTOMATIC("Automatic");

    private final String gearType;

    GearType(String gearType) {
        this.gearType = gearType;
    }

}

