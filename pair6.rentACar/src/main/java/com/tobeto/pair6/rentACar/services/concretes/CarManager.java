package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.entities.Car;
import com.tobeto.pair6.rentACar.repositories.CarRepository;
import com.tobeto.pair6.rentACar.services.abstracts.CarService;
import com.tobeto.pair6.rentACar.services.abstracts.ColorService;
import com.tobeto.pair6.rentACar.services.abstracts.ModelService;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.responses.GetAllCarsResponse;
import com.tobeto.pair6.rentACar.services.dtos.car.responses.GetByIdCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private final CarRepository carRepository;
    private final ModelMapperService modelMapperService;
    private final ModelService modelService;
    private final ColorService colorService;

    @Override
    public void add(AddCarRequest addCarRequest) {

        if (this.carRepository.existsByPlate(addCarRequest.getPlate())) {
            throw new RuntimeException("Aynı plaka ile 2. araç eklenemez!");
        }

        if (!modelService.getModelById(addCarRequest.getModelId())) {
            throw new RuntimeException("Verilen ModelId bir model db'de bulunmalıdır!");
        }

        if (!colorService.getColorById(addCarRequest.getColorId())) {
            throw new RuntimeException("Verilen ColorId bir color db'de bulunmalıdır!");
        }

        Car car = this.modelMapperService.forRequest().map(addCarRequest, Car.class);

        this.carRepository.save(car);

    }

    @Override
    public void delete(DeleteCarRequest deleteCarRequest) {

        Car car = this.modelMapperService.forRequest().map(deleteCarRequest, Car.class);

        this.carRepository.delete(car);
    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {

        if (this.carRepository.existsByPlate(updateCarRequest.getPlate())) {
            throw new RuntimeException("Bu plakaya ait bir araç zaten var! Var olan plaka ile güncelleme yapılamaz!");
        }

        if (!modelService.getModelById(updateCarRequest.getModelId())) {
            throw new RuntimeException("Verilen ModelId bir model db'de bulunmalıdır!");
        }

        if (!colorService.getColorById(updateCarRequest.getColorId())) {
            throw new RuntimeException("Verilen ColorId bir color db'de bulunmalıdır!");
        }

        Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);

        this.carRepository.save(car);

    }

    @Override
    public List<GetAllCarsResponse> getAll() {

        List<Car> cars = carRepository.findAll();

        List<GetAllCarsResponse> carsResponse = cars.stream()
                .map(car -> this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class)).toList();
        return carsResponse;
    }

    @Override
    public GetByIdCarResponse getById(int id) {

        Car car = carRepository.findById(id).orElseThrow();

        GetByIdCarResponse response = this.modelMapperService.forResponse().map(car, GetByIdCarResponse.class);

        return response;
    }

    @Override
    public boolean getCarById(int id) {
        return this.carRepository.existsById(id);
    }
}
