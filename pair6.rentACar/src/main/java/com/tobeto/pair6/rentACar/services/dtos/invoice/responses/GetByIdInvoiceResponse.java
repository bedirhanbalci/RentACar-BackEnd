package com.tobeto.pair6.rentACar.services.dtos.invoice.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdInvoiceResponse {

    private String invoiceNo;

    private Double taxRate;

    private Double rentalTotalPrice;

}
