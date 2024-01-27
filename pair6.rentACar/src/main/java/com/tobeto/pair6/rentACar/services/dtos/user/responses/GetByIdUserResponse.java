package com.tobeto.pair6.rentACar.services.dtos.user.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdUserResponse {

    private Integer id;

    private String email;

    private String password;

    private String phoneNumber;

    private String address;

    private String imagePath;

}
