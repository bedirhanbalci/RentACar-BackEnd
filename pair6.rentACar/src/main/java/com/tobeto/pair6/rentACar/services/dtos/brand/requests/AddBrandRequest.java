package com.tobeto.pair6.rentACar.services.dtos.brand.requests;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBrandRequest {

    @Size(min = 2, message = "Eklenecek marka en az 2 harften oluşmalıdır.")
    private String name;
}
