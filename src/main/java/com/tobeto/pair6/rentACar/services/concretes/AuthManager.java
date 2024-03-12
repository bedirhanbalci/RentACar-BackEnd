package com.tobeto.pair6.rentACar.services.concretes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tobeto.pair6.rentACar.core.services.JwtService;
import com.tobeto.pair6.rentACar.core.utilities.exceptions.BusinessException;
import com.tobeto.pair6.rentACar.entities.concretes.*;
import com.tobeto.pair6.rentACar.repositories.TokenRepository;
import com.tobeto.pair6.rentACar.repositories.UserRepository;
import com.tobeto.pair6.rentACar.services.abstracts.AuthService;
import com.tobeto.pair6.rentACar.services.abstracts.CorporateCustomerService;
import com.tobeto.pair6.rentACar.services.abstracts.IndividualCustomerService;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import com.tobeto.pair6.rentACar.services.dtos.auth.requests.CorporateLoginRequest;
import com.tobeto.pair6.rentACar.services.dtos.auth.requests.IndividualLoginRequest;
import com.tobeto.pair6.rentACar.services.dtos.auth.requests.LoginRequest;
import com.tobeto.pair6.rentACar.services.dtos.auth.requests.RegisterRequest;
import com.tobeto.pair6.rentACar.services.dtos.auth.responses.AuthenticationResponse;
import com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.requests.AddCorporate;
import com.tobeto.pair6.rentACar.services.dtos.individualCustomer.requests.AddIndividual;
import com.tobeto.pair6.rentACar.services.rules.UserBusinessRules;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {

    private final UserRepository userRepository;

    private final TokenRepository tokenRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final IndividualCustomerService individualCustomerService;

    private final CorporateCustomerService corporateCustomerService;

    private final UserBusinessRules userBusinessRules;

    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {

        var user = User.builder()
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .phoneNumber(registerRequest.getPhoneNumber())
                .role(Role.USER)
                .build();
        var savedUser = userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .user(savedUser)
                .refreshToken(refreshToken)
                .build();

    }

    @Override
    public AuthenticationResponse login(LoginRequest loginRequest) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        var user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .role(user.getRole())
                .id(user.getId())
                .build();

    }

    @Override
    public AuthenticationResponse individualLogin(IndividualLoginRequest individualLoginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(individualLoginRequest.getEmail(), individualLoginRequest.getPassword()));
        var user = userRepository.findByEmail(individualLoginRequest.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        if (!(user.getIndividualCustomers().size() > 0)){
            throw new BusinessException(Messages.INDIVIDUAL_USER_NOT_FOUND);
        }

        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .role(user.getRole())
                .id(user.getId())
                .build();
    }

    @Override
    public AuthenticationResponse corporateLogin(CorporateLoginRequest corporateLoginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(corporateLoginRequest.getEmail(), corporateLoginRequest.getPassword()));
        var user = userRepository.findByEmail(corporateLoginRequest.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        if (!(user.getCorporateCustomers().size() > 0)){
            throw new BusinessException(Messages.CORPORATE_USER_NOT_FOUND);
        }
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .role(user.getRole())
                .id(user.getId())
                .build();
    }


    @Override
    public void saveUserToken(User user, String jwtToken) {

        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);

    }

    @Override
    public void revokeAllUserTokens(User user) {

        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);

    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {

        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.userRepository.findByEmail(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);

            }
        }
    }

    @Override
    public void registerIndividual(AddIndividual addIndividual) {

        this.userBusinessRules.checkIfUserByEmailExists(addIndividual.getEmail());

        IndividualCustomer individualCustomer = IndividualCustomer.builder()
                .firstName(addIndividual.getFirstName())
                .lastName(addIndividual.getLastName())
                .birthDate(addIndividual.getBirthDate())
                .nationalityNo(addIndividual.getNationalityNo())
                .build();

        AuthenticationResponse response = this.register(new RegisterRequest(addIndividual.getEmail(), addIndividual.getPassword(), addIndividual.getPhoneNumber()));

        individualCustomer.setUser(response.getUser());

        this.individualCustomerService.addIndividual(individualCustomer);

    }

    @Override
    public void registerCorporate(AddCorporate addCorporate) {

        this.userBusinessRules.checkIfUserByEmailExists(addCorporate.getEmail());

        CorporateCustomer corporateCustomer = CorporateCustomer.builder()
                .companyName(addCorporate.getCompanyName())
                .contactName(addCorporate.getContactName())
                .contactTitle(addCorporate.getContactTitle())
                .taxNumber(addCorporate.getTaxNumber())
                .build();

        AuthenticationResponse response = this.register(new RegisterRequest(addCorporate.getEmail(), addCorporate.getPassword(), addCorporate.getPhoneNumber()));

        corporateCustomer.setUser(response.getUser());

        this.corporateCustomerService.addCorporate(corporateCustomer);

    }
}
