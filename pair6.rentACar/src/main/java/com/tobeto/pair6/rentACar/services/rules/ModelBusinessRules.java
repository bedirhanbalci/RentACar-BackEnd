package com.tobeto.pair6.rentACar.services.rules;

import com.tobeto.pair6.rentACar.core.utilities.exceptions.BusinessException;
import com.tobeto.pair6.rentACar.repositories.ModelRepository;
import com.tobeto.pair6.rentACar.services.abstracts.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelBusinessRules {

    private final ModelRepository modelRepository;
    private final BrandService brandService;

    public void checkIfModelByNameExists(String name) {
        if (this.modelRepository.existsByName(name)) {
            throw new BusinessException("Aynı Model 2. kez eklenemez!");
        }
    }

    public void checkIfBrandByIdExists(Integer id) {
        if (!brandService.getBrandById(id)) {
            throw new BusinessException("Verilen Brand Id ile veritabanında bir Brand bulunmalıdır!");
        }
    }

    public void checkIfModelByIdExists(Integer id) {
        if (!this.modelRepository.existsById(id)) {
            throw new BusinessException("Verilen Model Id ile sistemde bir Model olmalıdır!");
        }
    }

}
