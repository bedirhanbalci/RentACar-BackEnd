package com.tobeto.pair6.rentACar.services.dtos.invoice.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInvoiceRequest {

    @Positive(message = "Doğru Id girişi yapınız!")
    private Integer id;

    @NotNull(message = "Fatura oluşturma numarası boş olamaz!")
    private String invoiceNo;

    private Double taxRate;

    @Positive(message = "Doğru Rental Id girişi yapınız!")
    private Integer rentalId;

}
