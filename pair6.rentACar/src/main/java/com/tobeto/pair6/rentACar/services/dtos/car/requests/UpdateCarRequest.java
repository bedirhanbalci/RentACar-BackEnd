package com.tobeto.pair6.rentACar.services.dtos.car.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {

    @Positive(message = "Doğru Id girişi yapınız!")
    private int id;

    @Positive(message = "Kilometer alanı 0'dan küçük olamaz!")
    private int kilometer;

    @NotBlank(message = "Plaka boş olamaz!")
    @Pattern(regexp = "^[0-9]{1,3}[A-Z]{1,2}[0-9]{2,3}$", message = "Geçersiz plaka formatı!")
    private String plate;

    @Size(min=2005,max = 2024, message = "Yıl bilgisi 2005-2024 arasında olmalıdır!")
    //@Min(value=2005)
    //@Max(value =2024)
    private int year;

    @Positive(message = "Daily Price 0'dan küçük olamaz!")
    private double dailyPrice;

    @Positive(message = "Doğru Model Id girişi yapınız!")
    private int modelId;

    @Positive(message = "Doğru Color Id girişi yapınız!")
    private int colorId;
}
