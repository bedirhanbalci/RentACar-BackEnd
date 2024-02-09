package com.tobeto.pair6.rentACar.services.rules;

import com.tobeto.pair6.rentACar.core.utilities.exceptions.BusinessException;
import com.tobeto.pair6.rentACar.repositories.CarRepository;
import com.tobeto.pair6.rentACar.services.abstracts.ColorService;
import com.tobeto.pair6.rentACar.services.abstracts.ModelService;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
public class CarBusinessRules {

    private final CarRepository carRepository;
    private final ModelService modelService;
    private final ColorService colorService;

    public void checkIfCarByPlateExists(String plate) {
        if (this.carRepository.existsByPlate(plate)) {
            throw new BusinessException(Messages.PLATE_ALREADY_EXISTS);
        }
    }

    public void checkIfModelByIdExists(Integer id) {
        if (!modelService.getModelById(id)) {
            throw new BusinessException(Messages.MODEL_NOT_EXIST);
        }
    }

    public void checkIfColorByIdExists(Integer id) {
        if (!colorService.getColorById(id)) {
            throw new BusinessException(Messages.COLOR_NOT_EXIST);
        }
    }

    public void checkIfCarByIdExists(Integer id) {
        if (!this.carRepository.existsById(id)) {
            throw new BusinessException(Messages.ID_NOT_FOUND);
        }
    }

    public double calculateTotalPrice(LocalDate startDate, LocalDate endDate, Double dailyPrice) {
        long rentalTime = ChronoUnit.DAYS.between(startDate, endDate);
        rentalTime++;
        return rentalTime * dailyPrice;
    }

}
