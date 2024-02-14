package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.entities.concretes.User;
import com.tobeto.pair6.rentACar.services.dtos.auth.requests.CorporateLoginRequest;
import com.tobeto.pair6.rentACar.services.dtos.auth.requests.IndividualLoginRequest;
import com.tobeto.pair6.rentACar.services.dtos.auth.requests.LoginRequest;
import com.tobeto.pair6.rentACar.services.dtos.auth.requests.RegisterRequest;
import com.tobeto.pair6.rentACar.services.dtos.auth.responses.AuthenticationResponse;
import com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.requests.AddCorporate;
import com.tobeto.pair6.rentACar.services.dtos.individualCustomer.requests.AddIndividual;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthService {

    AuthenticationResponse register(RegisterRequest registerRequest);

    AuthenticationResponse login(LoginRequest loginRequest);

    AuthenticationResponse individualLogin(IndividualLoginRequest individualLoginRequest);

    AuthenticationResponse corporateLogin(CorporateLoginRequest corporateLoginRequest);


    void saveUserToken(User user, String jwtToken);

    void revokeAllUserTokens(User user);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;

    void registerIndividual(AddIndividual addIndividual);

    void registerCorporate(AddCorporate addCorporate);
}
