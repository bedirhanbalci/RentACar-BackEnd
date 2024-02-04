package com.tobeto.pair6.rentACar.services.rules;

import com.tobeto.pair6.rentACar.core.utilities.exceptions.BusinessException;
import com.tobeto.pair6.rentACar.repositories.BrandRepository;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {

    private final BrandRepository brandRepository;

    public void checkIfBrandByNameExists(String name) {
        if (this.brandRepository.existsByName(name)) {
            throw new BusinessException(Messages.BRAND_ALREADY_EXISTS);
        }
    }

    public void checkIfBrandByIdExists(Integer id) {
        if (!this.brandRepository.existsById(id)) {
            throw new BusinessException(Messages.ID_NOT_FOUND);
        }
    }

}
