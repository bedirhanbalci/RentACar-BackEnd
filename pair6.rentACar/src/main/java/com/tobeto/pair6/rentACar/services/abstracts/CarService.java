package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.TotalPriceRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.responses.GetAllCarsResponse;
import com.tobeto.pair6.rentACar.services.dtos.car.responses.GetByIdCarResponse;

import java.util.List;

public interface CarService {
    Result add(AddCarRequest addCarRequest);

    Result delete(DeleteCarRequest deleteCarRequest);

    Result update(UpdateCarRequest updateCarRequest);

    DataResult<List<GetAllCarsResponse>> getAll();

    DataResult<GetByIdCarResponse> getById(Integer id);

    boolean getCarById(Integer id);

    Double totalPrice(TotalPriceRequest totalPriceRequest);
}
