package com.tobeto.pair6.rentACar.services.dtos.assurancePackage.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssuranceRequest {

    private Integer id;

    private LocalDate startDate;

    private LocalDate endDate;

}
