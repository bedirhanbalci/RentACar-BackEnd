package com.tobeto.pair6.rentACar.controllers;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.abstracts.RentalService;
import com.tobeto.pair6.rentACar.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.pair6.rentACar.services.dtos.rental.requests.DeleteRentalRequest;
import com.tobeto.pair6.rentACar.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.pair6.rentACar.services.dtos.rental.responses.GetAllRentalsResponse;
import com.tobeto.pair6.rentACar.services.dtos.rental.responses.GetByIdRentalResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@AllArgsConstructor
@CrossOrigin
public class RentalsController {

    private final RentalService rentalService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddRentalRequest addRentalRequest) {

        return this.rentalService.add(addRentalRequest);

    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody @Valid DeleteRentalRequest deleteRentalRequest) {

        return this.rentalService.delete(deleteRentalRequest);

    }

    @PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateRentalRequest updateRentalRequest) {

        return this.rentalService.update(updateRentalRequest);

    }

    @GetMapping("/getAll")
    public DataResult<List<GetAllRentalsResponse>> getAll() {

        return this.rentalService.getAll();

    }

    @GetMapping("/getById/{id}")
    public DataResult<GetByIdRentalResponse> getById(@PathVariable Integer id) {

        return this.rentalService.getById(id);

    }

}
