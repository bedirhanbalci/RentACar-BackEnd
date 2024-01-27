package com.tobeto.pair6.rentACar.services.dtos.branch.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBranchesResponse {

    private Integer id;

    private String city;

    private String address;

    private String phoneNumber;

    private Double latitude;

    private Double longitude;

}
