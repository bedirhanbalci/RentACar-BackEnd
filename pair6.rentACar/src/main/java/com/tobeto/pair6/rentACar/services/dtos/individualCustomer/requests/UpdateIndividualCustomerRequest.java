package com.tobeto.pair6.rentACar.services.dtos.individualCustomer.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateIndividualCustomerRequest {

    private Integer id;

    private String firstName;

    private String lastName;

    private String nationalityNo;

    private LocalDate birthDate;

    private Integer userId;

}
