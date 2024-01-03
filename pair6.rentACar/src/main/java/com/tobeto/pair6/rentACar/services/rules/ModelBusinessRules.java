package com.tobeto.pair6.rentACar.services.rules;

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
            throw new RuntimeException("Aynı Model 2. kez eklenemez!");
        }
    }

    public void checkIfBrandByIdExists(int id) {
        if (!brandService.getBrandById(id)) {
            throw new RuntimeException("Verilen Brand Id ile veritabanında bir kayıt bulunmalıdır!");
        }
    }

    public void checkIfModelByIdExists(int id) {
        if (!this.modelRepository.existsById(id)) {
            throw new RuntimeException("Verilen Model Id ile sistemde bir model olmalıdır!");
        }
    }

}
