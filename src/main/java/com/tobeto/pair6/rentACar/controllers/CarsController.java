package com.tobeto.pair6.rentACar.controllers;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.abstracts.CarService;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.TotalPriceRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.responses.GetAllCarsResponse;
import com.tobeto.pair6.rentACar.services.dtos.car.responses.GetByIdCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
@CrossOrigin
public class CarsController {

    private final CarService carService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddCarRequest addCarRequest) {

        return this.carService.add(addCarRequest);

    }

    @DeleteMapping()
    public Result delete(@RequestBody @Valid DeleteCarRequest deleteCarRequest) {

        return this.carService.delete(deleteCarRequest);

    }

    @PutMapping()
    public Result update(@RequestBody @Valid UpdateCarRequest updateCarRequest) {

        return this.carService.update(updateCarRequest);

    }

    @GetMapping()
    public DataResult<List<GetAllCarsResponse>> getAll() {

        return this.carService.getAll();

    }

    @GetMapping("/{id}")
    public DataResult<GetByIdCarResponse> getById(@PathVariable Integer id) {

        return this.carService.getById(id);

    }

    @PostMapping("/totalPrice")
    public Double totalPrice(@RequestBody TotalPriceRequest totalPriceRequest) {

        return this.carService.totalPrice(totalPriceRequest);

    }

}
