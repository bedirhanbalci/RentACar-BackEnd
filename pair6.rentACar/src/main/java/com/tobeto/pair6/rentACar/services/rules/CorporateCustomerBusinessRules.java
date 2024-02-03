package com.tobeto.pair6.rentACar.services.rules;

import com.tobeto.pair6.rentACar.core.utilities.exceptions.BusinessException;
import com.tobeto.pair6.rentACar.repositories.CorporateCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CorporateCustomerBusinessRules {

    private final CorporateCustomerRepository corporateCustomerRepository;

    public void checkIfCorporateCustomerByIdExists(Integer id) {
        if (!this.corporateCustomerRepository.existsById(id)) {
            throw new BusinessException("Verilen Corporate Customer Id ile sistemde bir Corporate Customer olmalıdır!");
        }
    }

}
