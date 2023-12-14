package com.tobeto.pair6.rentACar.services.dtos.invoice.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInvoiceRequest {
    private int id;

    private LocalDate createDate;

    private double totalPrice;
}
