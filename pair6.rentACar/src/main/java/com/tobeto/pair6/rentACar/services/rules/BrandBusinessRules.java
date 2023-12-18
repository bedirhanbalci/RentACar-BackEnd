package com.tobeto.pair6.rentACar.services.rules;

import com.tobeto.pair6.rentACar.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {

    private final BrandRepository brandRepository;

    public void checkIfBrandByNameExists(String name) {
        if (this.brandRepository.existsByName(name)) {
            throw new RuntimeException("Aynı marka 2. kez eklenemez!");
        }
    }
}
