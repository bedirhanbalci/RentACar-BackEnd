package com.tobeto.pair6.rentACar.services.dtos.model.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddModelRequest {
    private String name;
    private String brandName;
}
