package com.tobeto.pair6.rentACar.services.dtos.car.requests;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {

    @Positive(message = "Kilometer 0'dan küçük olamaz!")
    private int kilometer;

    @NotBlank(message = "Plaka boş olamaz!")
    @Pattern(regexp = "^(0[1-9]|[1-7][0-9]|8[01])(([A-Z])(\\d{4,5})|([A-Z]{2})(\\d{3,4})|([A-Z]{3})(\\d{2,3}))$", message = "Geçersiz Plaka formatı!")
    private String plate;

    public void setPlate(String plate) {
        this.plate = plate != null ? plate.replaceAll("\\s", "") : null;
    }

    @Min(value = 2005, message = "Yıl bilgisi 2005'den küçük olamaz!")
    @Max(value = 2024, message = "Yıl bilgisi 2024'den büyük olamaz!")
    private int year;

    @Positive(message = "Daily Price 0'dan küçük olamaz!")
    private double dailyPrice;

    @Positive(message = "Doğru Model Id girişi yapınız!")
    private int modelId;

    @Positive(message = "Doğru Color Id girişi yapınız!")
    private int colorId;

}
