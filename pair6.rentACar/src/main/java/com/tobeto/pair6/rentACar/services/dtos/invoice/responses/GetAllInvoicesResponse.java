package com.tobeto.pair6.rentACar.services.dtos.invoice.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllInvoicesResponse {

    private LocalDate createDate;

    private double totalPrice;
}
