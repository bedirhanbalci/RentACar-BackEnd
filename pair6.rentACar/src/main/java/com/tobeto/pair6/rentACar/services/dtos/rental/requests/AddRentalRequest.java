package com.tobeto.pair6.rentACar.services.dtos.rental.requests;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalRequest {

    private LocalDate startDate;
    private LocalDate endDate;
    @Positive(message = "Doğru Model Id girişi yapınız!")
    private int carId;
    @Positive(message = "Doğru User Id girişi yapınız!")
    private int userId;
}
