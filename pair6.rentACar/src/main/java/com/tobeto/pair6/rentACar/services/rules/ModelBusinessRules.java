package com.tobeto.pair6.rentACar.services.rules;

import com.tobeto.pair6.rentACar.core.utilities.exceptions.BusinessException;
import com.tobeto.pair6.rentACar.repositories.ModelRepository;
import com.tobeto.pair6.rentACar.services.abstracts.BrandService;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelBusinessRules {

    private final ModelRepository modelRepository;
    private final BrandService brandService;

    public void checkIfModelByNameExists(String name) {
        if (this.modelRepository.existsByName(name)) {
            throw new BusinessException(Messages.MODEL_ALREADY_EXISTS);
        }
    }

    public void checkIfBrandByIdExists(Integer id) {
        if (!brandService.getBrandById(id)) {
            throw new BusinessException(Messages.BRAND_NOT_EXIST);
        }
    }

    public void checkIfModelByIdExists(Integer id) {
        if (!this.modelRepository.existsById(id)) {
            throw new BusinessException(Messages.ID_NOT_FOUND);
        }
    }

}
