package com.tobeto.pair6.rentACar.services.dtos.branch.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBranchRequest {

    private Integer id;

    private String city;

    private String address;

    private String phoneNumber;

    private Double latitude;

    private Double longitude;

}
