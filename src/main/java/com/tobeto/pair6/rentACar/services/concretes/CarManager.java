package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessDataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.pair6.rentACar.entities.concretes.Car;
import com.tobeto.pair6.rentACar.repositories.CarRepository;
import com.tobeto.pair6.rentACar.services.abstracts.CarService;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.TotalPriceRequest;
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
    public Result add(AddCarRequest addCarRequest) {

        this.carBusinessRules.checkIfCarByPlateExists(addCarRequest.getPlate());

        this.carBusinessRules.checkIfModelByIdExists(addCarRequest.getModelId());

        this.carBusinessRules.checkIfColorByIdExists(addCarRequest.getColorId());


        Car car = this.modelMapperService.forRequest()
                .map(addCarRequest, Car.class);
        car.setId(null);

        this.carRepository.save(car);

        return new SuccessResult(Messages.ADD);

    }

    @Override
    public Result delete(DeleteCarRequest deleteCarRequest) {

        this.carBusinessRules.checkIfCarByIdExists(deleteCarRequest.getId());

        Car car = this.modelMapperService.forRequest()
                .map(deleteCarRequest, Car.class);

        this.carRepository.delete(car);

        return new SuccessResult(Messages.DELETE);

    }

    @Override
    public Result update(UpdateCarRequest updateCarRequest) {

        this.carBusinessRules.checkIfCarByIdExists(updateCarRequest.getId());

        this.carBusinessRules.checkIfCarByPlateExists(updateCarRequest.getPlate());

        this.carBusinessRules.checkIfModelByIdExists(updateCarRequest.getModelId());

        this.carBusinessRules.checkIfColorByIdExists(updateCarRequest.getColorId());


        Car car = this.modelMapperService.forRequest()
                .map(updateCarRequest, Car.class);

        this.carRepository.save(car);

        return new SuccessResult(Messages.UPDATE);

    }

    @Override
    public DataResult<List<GetAllCarsResponse>> getAll() {

        List<Car> cars = carRepository.findAll();

        List<GetAllCarsResponse> carsResponse = cars.stream()
                .map(car -> {GetAllCarsResponse response = this.modelMapperService.forResponse()
                        .map(car, GetAllCarsResponse.class);
                    response.setBrandName(car.getModel().getBrand().getName());return response;}).toList();

        return new SuccessDataResult<>(carsResponse, Messages.GET_ALL);

    }

    @Override
    public DataResult<GetByIdCarResponse> getById(Integer id) {

        this.carBusinessRules.checkIfCarByIdExists(id);

        Car car = carRepository.findById(id).orElseThrow();

        GetByIdCarResponse response = this.modelMapperService.forResponse()
                .map(car, GetByIdCarResponse.class);

        response.setBrandName(car.getModel().getBrand().getName());

        return new SuccessDataResult<>(response, Messages.GET);

    }

    @Override

    public boolean getCarById(Integer id) {

        return this.carRepository.existsById(id);

    }

    @Override
    public Double totalPrice(TotalPriceRequest totalPriceRequest) {

        DataResult <GetByIdCarResponse> response = this.getById(totalPriceRequest.getCarId());
        return this.carBusinessRules.calculateTotalPrice(totalPriceRequest.getStartDate(), totalPriceRequest.getEndDate(), response.getData().getDailyPrice());

    }

}
