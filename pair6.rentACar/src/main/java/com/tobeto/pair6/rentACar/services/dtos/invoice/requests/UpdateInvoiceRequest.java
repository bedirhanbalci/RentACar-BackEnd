package com.tobeto.pair6.rentACar.services.dtos.invoice.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInvoiceRequest {

    @Positive(message = "Doğru Id girişi yapınız!")
    private int id;

    @NotNull(message = "Fatura oluşturma tarihi boş olamaz!")
    private LocalDate createDate;

    @Positive(message = "Doğru Rental Id girişi yapınız!")
    private int rentalId;

}
