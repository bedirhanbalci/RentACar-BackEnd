package com.tobeto.pair6.rentACar.services.dtos.color.requests;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddColorRequest {

    @Size(min = 2, message = "Eklenecek renk en az 2 harften oluşmalıdır!")
    private String name;
}
