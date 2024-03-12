package com.tobeto.pair6.rentACar.services.dtos.auth.responses;

import com.tobeto.pair6.rentACar.entities.concretes.Role;
import com.tobeto.pair6.rentACar.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private Integer id;

    private String accessToken;

    private String refreshToken;

    private Role role;

    private User user;

}
