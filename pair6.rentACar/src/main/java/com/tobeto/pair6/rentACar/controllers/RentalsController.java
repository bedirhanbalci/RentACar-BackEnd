package com.tobeto.pair6.rentACar.controllers;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.abstracts.RentalService;
import com.tobeto.pair6.rentACar.services.dtos.invoice.responses.GetByIdInvoiceResponse;
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

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public GetByIdInvoiceResponse add(@RequestBody @Valid AddRentalRequest addRentalRequest) {

        return this.rentalService.add(addRentalRequest);

    }

    @DeleteMapping()
    public Result delete(@RequestBody @Valid DeleteRentalRequest deleteRentalRequest) {

        return this.rentalService.delete(deleteRentalRequest);

    }

    @PutMapping()
    public Result update(@RequestBody @Valid UpdateRentalRequest updateRentalRequest) {

        return this.rentalService.update(updateRentalRequest);

    }

    @GetMapping()
    public DataResult<List<GetAllRentalsResponse>> getAll() {

        return this.rentalService.getAll();

    }

    @GetMapping("/{id}")
    public DataResult<GetByIdRentalResponse> getById(@PathVariable Integer id) {

        return this.rentalService.getById(id);

    }

    @GetMapping("/getByUserId/{id}")
    public List<List<Object>> getByUserId(@PathVariable Integer id) {

        return this.rentalService.getByUserId(id);

    }

    @PostMapping("/dateValid")
    public void checkIfRentalByDateValid(@RequestBody @Valid AddRentalRequest addRentalRequest) {

         this.rentalService.checkIfRentalByDateValid(addRentalRequest);

    }





}
