package com.tobeto.pair6.rentACar.services.dtos.invoice.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddInvoiceRequest {

    @NotBlank(message = "Invoice No cannot be blank!")
    private String invoiceNo;

    @Positive(message = "Rental Id must be a positive number!")
    private Integer rentalId;

}
