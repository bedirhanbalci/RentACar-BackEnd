package com.tobeto.pair6.rentACar.services.dtos.individualCustomer.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllIndividualCustomersResponse {

    private Integer id;

    private String firstName;

    private String lastName;

    private String nationalityNo;

    private LocalDate birthDate;

    private String userEmail;

}
