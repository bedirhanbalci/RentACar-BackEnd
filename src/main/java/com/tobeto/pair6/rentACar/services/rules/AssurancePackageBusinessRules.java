package com.tobeto.pair6.rentACar.services.rules;

import com.tobeto.pair6.rentACar.core.utilities.exceptions.BusinessException;
import com.tobeto.pair6.rentACar.repositories.AssurancePackageRepository;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
public class AssurancePackageBusinessRules {

    private final AssurancePackageRepository assurancePackageRepository;

    public void checkIfAssurancePackageByIdExists(Integer id) {
        if (!this.assurancePackageRepository.existsById(id)) {
            throw new BusinessException(Messages.ID_NOT_FOUND);
        }
    }

    public double calculateAssurancePrice(LocalDate startDate, LocalDate endDate, Double dailyPrice) {
        long assuranceTime = ChronoUnit.DAYS.between(startDate, endDate);
        assuranceTime++;
        return assuranceTime * dailyPrice;
    }

}
