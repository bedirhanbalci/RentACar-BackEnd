package com.tobeto.pair6.rentACar.services.rules;

import com.tobeto.pair6.rentACar.core.utilities.exceptions.BusinessException;
import com.tobeto.pair6.rentACar.repositories.RentalRepository;
import com.tobeto.pair6.rentACar.services.abstracts.CarService;
import com.tobeto.pair6.rentACar.services.abstracts.UserService;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
public class RentalBusinessRules {

    private final RentalRepository rentalRepository;
    private final CarService carService;
    private final UserService userService;

    public void checkIfCarByIdExists(Integer id) {
        if (!carService.getCarById(id)) {
            throw new BusinessException(Messages.CAR_NOT_EXIST);
        }
    }

    public void checkIfUserByIdExists(Integer id) {
        if (!userService.getUserById(id)) {
            throw new BusinessException(Messages.USER_NOT_EXIST);
        }
    }

    public void checkIfRentalByStartDate(LocalDate startDate) {
        if (startDate.isBefore(LocalDate.now())) {
            throw new BusinessException(Messages.START_DATE_ERROR);
        }
    }

    public void checkIfRentalByEndDate(LocalDate endDate, LocalDate startDate) {
        if (endDate.isBefore(startDate)) {
            throw new BusinessException(Messages.END_DATE_ERROR);
        }
    }

    public void checkIfRentalByDateValid(LocalDate startDate, LocalDate endDate) {
        if (ChronoUnit.DAYS.between(startDate, endDate) > 25) {
            throw new BusinessException(Messages.MAX_DAYS_ERROR);
        }
    }

    public double calculateTotalPrice(LocalDate startDate, LocalDate endDate, Double dailyPrice) {
        long rentalTime = ChronoUnit.DAYS.between(startDate, endDate);
        rentalTime++;
        return rentalTime * dailyPrice;
    }

    public void checkIfRentalByIdExists(Integer id) {
        if (!this.rentalRepository.existsById(id)) {
            throw new BusinessException(Messages.ID_NOT_FOUND);
        }
    }

}
