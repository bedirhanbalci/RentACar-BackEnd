package com.tobeto.pair6.rentACar.services.dtos.rental.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalRequest {

    @NotNull(message = "Başlangıç tarihi boş olamaz!")
    private LocalDate startDate;

    @NotNull(message = "Bitiş tarihi boş olamaz!")
    private LocalDate endDate;

    @Positive(message = "Doğru Car Id girişi yapınız!")
    private int carId;

    @Positive(message = "Doğru User Id girişi yapınız!")
    private int userId;
}
