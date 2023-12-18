package com.tobeto.pair6.rentACar.services.rules;

import com.tobeto.pair6.rentACar.repositories.RentalRepository;
import com.tobeto.pair6.rentACar.services.abstracts.CarService;
import com.tobeto.pair6.rentACar.services.abstracts.UserService;
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

    public void checkIfCarByIdExists(int id) {
        if (!carService.getCarById(id)) {
            throw new RuntimeException("Verilen Car Id ile sistemde bir araba olmalıdır!");
        }
    }

    public void checkIfUserByIdExists(int id) {
        if (!userService.getUserById(id)) {
            throw new RuntimeException("Verilen User Id ile sistemde bir kullanıcı olmalıdır!");
        }
    }

    public void checkIfRentalByStartDate(LocalDate startDate) {
        if (startDate.isBefore(LocalDate.now())) {
            throw new RuntimeException("Araç kiralarken verilen başlangıç tarihi bugünden daha geçmiş bir tarih olamaz!");
        }
    }

    public void checkIfRentalByEndDate(LocalDate endDate, LocalDate startDate) {
        if (endDate.isBefore(startDate)) {
            throw new RuntimeException("Araç kiralarken verilen bitiş tarihi başlangıç tarihinden daha geçmiş bi tarih olamaz!");
        }
    }

    public void checkIfRentalByDateValid(LocalDate startDate, LocalDate endDate) {
        if (ChronoUnit.DAYS.between(startDate, endDate) > 25) {
            throw new RuntimeException("Bir araç maksimum 25 gün kiralanabilir!");
        }
    }

    public double calculateTotalPrice(LocalDate startDate, LocalDate endDate, double dailyPrice) {
        long rentalTime = ChronoUnit.DAYS.between(startDate, endDate);
        return rentalTime * dailyPrice;
    }

}
