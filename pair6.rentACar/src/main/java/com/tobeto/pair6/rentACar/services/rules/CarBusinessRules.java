package com.tobeto.pair6.rentACar.services.rules;

import com.tobeto.pair6.rentACar.repositories.CarRepository;
import com.tobeto.pair6.rentACar.services.abstracts.ColorService;
import com.tobeto.pair6.rentACar.services.abstracts.ModelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarBusinessRules {

    private final CarRepository carRepository;
    private final ModelService modelService;
    private final ColorService colorService;

    public void checkIfCarByPlateExists(String plate) {
        if (this.carRepository.existsByPlate(plate)) {
            throw new RuntimeException("Aynı plaka ile 2. araç eklenemez!");
        }
    }

    public void checkIfModelByIdExists(Integer id) {
        if (!modelService.getModelById(id)) {
            throw new RuntimeException("Verilen Model Id bir model db'de bulunmalıdır!");
        }
    }

    public void checkIfColorByIdExists(Integer id) {
        if (!colorService.getColorById(id)) {
            throw new RuntimeException("Verilen Color Id bir color db'de bulunmalıdır!");
        }
    }

    public void checkIfCarByIdExists(Integer id) {
        if (!this.carRepository.existsById(id)) {
            throw new RuntimeException("Verilen Car Id ile sistemde bir Car olmalıdır!");
        }
    }

}
