package com.tobeto.pair6.rentACar.services.dtos.car.requests;

import com.tobeto.pair6.rentACar.entities.concretes.BodyType;
import com.tobeto.pair6.rentACar.entities.concretes.FuelType;
import com.tobeto.pair6.rentACar.entities.concretes.GearType;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {

    @Positive(message = "Kilometer must be a positive number!")
    private Integer kilometer;

    @Pattern(regexp = "^(0[1-9]|[1-7][0-9]|8[01])(([A-Z])(\\d{4,5})|([A-Z]{2})(\\d{3,4})|([A-Z]{3})(\\d{2,3}))$", message = "Invalid Turkish license plate format!")
    private String plate;

    public void setPlate(String plate) {
        this.plate = plate != null ? plate.replaceAll("\\s", "") : null;
    }

    @Min(value = 2005, message = "Year must be at least 2005!")
    @Max(value = 2024, message = "Year cannot be more than 2024!")
    private Integer year;

    @Positive(message = "Daily Price must be a positive number!")
    private Double dailyPrice;

    @NotBlank(message = "Image Path cannot be blank!")
    private String imagePath;

    private GearType gearType;

    private FuelType fuelType;

    private BodyType bodyType;

    @Positive(message = "Model Id must be a positive number!")
    private Integer modelId;

    @Positive(message = "Color Id must be a positive number!")
    private Integer colorId;

    @Positive(message = "Branch Id must be a positive number!")
    private Integer branchId;

}
