package com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCorporateCustomerRequest {

    private Integer id;

    private String companyName;

    private String contactName;

    private String contactTitle;

    private String taxNumber;

    private Integer userId;

}
