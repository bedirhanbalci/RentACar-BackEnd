package com.tobeto.pair6.rentACar.services.dtos.user.requests;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteUserRequest {

    @Positive(message = "Doğru Id girişi yapınız!")
    private Integer id;

}
