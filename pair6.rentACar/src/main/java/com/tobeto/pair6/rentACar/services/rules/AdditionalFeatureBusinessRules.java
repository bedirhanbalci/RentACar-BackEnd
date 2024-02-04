package com.tobeto.pair6.rentACar.services.rules;

import com.tobeto.pair6.rentACar.core.utilities.exceptions.BusinessException;
import com.tobeto.pair6.rentACar.repositories.AdditionalFeatureRepository;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdditionalFeatureBusinessRules {

    private final AdditionalFeatureRepository additionalFeatureRepository;

    public void checkIfAdditionalFeatureByIdExists(Integer id) {
        if (!this.additionalFeatureRepository.existsById(id)) {
            throw new BusinessException(Messages.ID_NOT_FOUND);
        }
    }

}
