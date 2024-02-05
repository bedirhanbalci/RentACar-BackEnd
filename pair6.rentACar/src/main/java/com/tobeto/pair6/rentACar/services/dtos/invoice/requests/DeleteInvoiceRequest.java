package com.tobeto.pair6.rentACar.services.dtos.invoice.requests;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteInvoiceRequest {

    @Positive(message = "Id must be a positive number!")
    private Integer id;

}
