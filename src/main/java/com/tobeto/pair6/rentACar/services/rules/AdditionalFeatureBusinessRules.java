package com.tobeto.pair6.rentACar.services.rules;

import com.tobeto.pair6.rentACar.core.utilities.exceptions.BusinessException;
import com.tobeto.pair6.rentACar.repositories.AdditionalFeatureRepository;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
public class AdditionalFeatureBusinessRules {

    private final AdditionalFeatureRepository additionalFeatureRepository;

    public void checkIfAdditionalFeatureByIdExists(Integer id) {
        if (!this.additionalFeatureRepository.existsById(id)) {
            throw new BusinessException(Messages.ID_NOT_FOUND);
        }
    }

    public double calculateAdditionalPrice(LocalDate startDate, LocalDate endDate, Double dailyPrice, Integer quantity) {
        long assuranceTime = ChronoUnit.DAYS.between(startDate, endDate);
        assuranceTime++;
        return assuranceTime * dailyPrice * quantity;
    }

}
