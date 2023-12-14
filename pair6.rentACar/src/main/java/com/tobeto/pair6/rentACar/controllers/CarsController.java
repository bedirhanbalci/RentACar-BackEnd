package com.tobeto.pair6.rentACar.controllers;

import com.tobeto.pair6.rentACar.services.abstracts.CarService;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.requests.DeleteCarRequest;
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
public class CarsController {

    private final CarService carService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddCarRequest addCarRequest) {
        carService.add(addCarRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteCarRequest deleteCarRequest) {
        carService.delete(deleteCarRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateCarRequest updateCarRequest) {
        carService.update(updateCarRequest);
    }

    @GetMapping("/getAll")
    public List<GetAllCarsResponse> getAll() {
        return carService.getAll();
    }

    @GetMapping("/getById")
    public GetByIdCarResponse getById(int id) {
        return carService.getById(id);
    }
}
