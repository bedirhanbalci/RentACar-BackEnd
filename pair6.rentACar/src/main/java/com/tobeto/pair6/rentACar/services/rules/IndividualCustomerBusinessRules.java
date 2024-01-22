package com.tobeto.pair6.rentACar.services.rules;

import com.tobeto.pair6.rentACar.repositories.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IndividualCustomerBusinessRules {

    private final IndividualCustomerRepository individualCustomerRepository;

    public void checkIfIndividualCustomerByIdExists(Integer id) {
        if (!this.individualCustomerRepository.existsById(id)) {
            throw new RuntimeException("Verilen Individual Customer Id ile sistemde bir Individual Customer olmalıdır!");
        }
    }

}
