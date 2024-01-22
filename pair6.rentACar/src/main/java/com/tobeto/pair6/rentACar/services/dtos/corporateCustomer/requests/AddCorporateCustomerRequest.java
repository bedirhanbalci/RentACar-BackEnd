package com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCorporateCustomerRequest {

    private String companyName;

    private String contactName;

    private String contactTitle;

    private String taxNumber;

    private Integer userId;

}
