package com.tobeto.pair6.rentACar.services.dtos.user.requests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    @Positive(message = "Doğru Id girişi yapınız!")
    private Integer id;

    @NotBlank(message = "Email boş olamaz!")
    @Email(message = "Email doğru formatta olmalıdır!")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "image_path")
    private String imagePath;

}
