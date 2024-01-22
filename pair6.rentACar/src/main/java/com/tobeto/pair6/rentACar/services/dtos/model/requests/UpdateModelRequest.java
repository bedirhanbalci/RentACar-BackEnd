package com.tobeto.pair6.rentACar.services.dtos.model.requests;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateModelRequest {

    @Positive(message = "Doğru Id girişi yapınız!")
    private Integer id;

    @Size(min = 2, message = "Eklenecek model en az 2 harften oluşmalıdır!")
    private String name;

    @Positive(message = "Doğru Brand Id girişi yapınız!")
    private Integer brandId;

}
