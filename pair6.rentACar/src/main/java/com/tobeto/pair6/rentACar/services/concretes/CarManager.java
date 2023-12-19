package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.entities.Car;
import com.tobeto.pair6.rentACar.repositories.CarRepository;
import com.tobeto.pair6.rentACar.services.abstracts.CarService;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.responses.GetAllCarsResponse;
import com.tobeto.pair6.rentACar.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair6.rentACar.services.rules.CarBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private final CarRepository carRepository;
    private final ModelMapperService modelMapperService;
    private final CarBusinessRules carBusinessRules;

    @Override
    public void add(AddCarRequest addCarRequest) {

        this.carBusinessRules.checkIfCarByPlateExists(addCarRequest.getPlate());

        this.carBusinessRules.checkIfModelByIdExists(addCarRequest.getModelId());

        this.carBusinessRules.checkIfColorByIdExists(addCarRequest.getColorId());


        Car car = this.modelMapperService.forRequest().map(addCarRequest, Car.class);

        this.carRepository.save(car);

    }

    @Override
    public void delete(DeleteCarRequest deleteCarRequest) {

        this.carBusinessRules.checkIfCarByIdExists(deleteCarRequest.getId());

        Car car = this.modelMapperService.forRequest().map(deleteCarRequest, Car.class);

        this.carRepository.delete(car);
    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {

        this.carBusinessRules.checkIfCarByIdExists(updateCarRequest.getId());

        this.carBusinessRules.checkIfCarByPlateExists(updateCarRequest.getPlate());

        this.carBusinessRules.checkIfModelByIdExists(updateCarRequest.getModelId());

        this.carBusinessRules.checkIfColorByIdExists(updateCarRequest.getColorId());


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

        this.carBusinessRules.checkIfCarByIdExists(id);

        GetByIdCarResponse response = this.modelMapperService.forResponse().map(carRepository.findById(id), GetByIdCarResponse.class);

        return response;
    }

    @Override
    public boolean getCarById(int id) {
        return this.carRepository.existsById(id);
    }
}
