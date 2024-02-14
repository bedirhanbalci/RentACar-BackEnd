package com.tobeto.pair6.rentACar.services.dtos.auth.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CorporateLoginRequest {

    private String email;

    private String password;

}
