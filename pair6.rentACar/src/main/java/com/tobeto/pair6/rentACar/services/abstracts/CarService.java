package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.responses.GetAllCarsResponse;
import com.tobeto.pair6.rentACar.services.dtos.car.responses.GetByIdCarResponse;

import java.util.List;

public interface CarService {
    void add(AddCarRequest addCarRequest);

    void delete(DeleteCarRequest deleteCarRequest);

    void update(UpdateCarRequest updateCarRequest);

    List<GetAllCarsResponse> getAll();

    GetByIdCarResponse getById(int id);

    boolean getCarById(int id);

}
