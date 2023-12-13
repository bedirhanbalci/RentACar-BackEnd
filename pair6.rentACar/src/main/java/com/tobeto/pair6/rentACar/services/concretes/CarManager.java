package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.entities.Car;
import com.tobeto.pair6.rentACar.entities.Color;
import com.tobeto.pair6.rentACar.entities.Model;
import com.tobeto.pair6.rentACar.repositories.CarRepository;
import com.tobeto.pair6.rentACar.services.abstracts.CarService;
import com.tobeto.pair6.rentACar.services.abstracts.ColorService;
import com.tobeto.pair6.rentACar.services.abstracts.ModelService;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.responses.GetAllCarsResponse;
import com.tobeto.pair6.rentACar.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair6.rentACar.services.dtos.color.responses.GetByIdColorResponse;
import com.tobeto.pair6.rentACar.services.dtos.model.responses.GetByIdModelResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
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

        if (carRepository.existsByPlate(addCarRequest.getPlate())){
            throw new RuntimeException("Aynı plaka ile 2. araç olamaz");
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

        Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);

        this.carRepository.save(car);

    }

    @Override
    public List<GetAllCarsResponse> getAll() {

        List<Car> cars = carRepository.findAll();

        List<GetAllCarsResponse> carsResponse = cars.stream()
                .map(car -> this.modelMapperService.forResponse().map(car,GetAllCarsResponse.class)).toList();
        return carsResponse;
    }

    @Override
    public GetByIdCarResponse getById(int id) {

        Car car = carRepository.findById(id).orElseThrow();


        GetByIdCarResponse response = this.modelMapperService.forResponse().map(car, GetByIdCarResponse.class);

        return response;
    }
}
