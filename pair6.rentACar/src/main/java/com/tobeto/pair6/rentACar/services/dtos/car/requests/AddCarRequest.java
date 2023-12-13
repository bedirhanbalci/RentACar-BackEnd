package com.tobeto.pair6.rentACar.services.dtos.car.requests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {

    @Positive(message = "Kilometer alanı 0'dan küçük olamaz!")
    private int kilometer;

    @NotBlank(message = "Plaka boş olamaz!")
    @Pattern(regexp = "^[0-9]{1,3}[A-Z]{1,2}[0-9]{2,3}$", message = "Geçersiz plaka formatı!")
    private String plate;

    @Min(value=2005, message = "Yıl bilgisi en az 2005 olmalıdır!")
    @Max(value =2024, message = "Yıl bilgisi en fazla 2024 olmalıdır!")
    private int year;

    @Positive(message = "Daily Price 0'dan küçük olamaz!")
    private double dailyPrice;

    @Positive(message = "Doğru Model Id girişi yapınız!")
    private int modelId;

    @Positive(message = "Doğru Color Id girişi yapınız!")
    private int colorId;

}
