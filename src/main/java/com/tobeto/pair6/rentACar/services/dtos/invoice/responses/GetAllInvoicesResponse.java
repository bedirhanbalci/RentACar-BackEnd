package com.tobeto.pair6.rentACar.services.dtos.invoice.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllInvoicesResponse {

    private Integer id;

    private String invoiceNo;

    private Double generalPrice;

}
