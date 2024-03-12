package com.tobeto.pair6.rentACar.controllers;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.abstracts.IndividualCustomerService;
import com.tobeto.pair6.rentACar.services.dtos.individualCustomer.requests.AddIndividualCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.individualCustomer.requests.DeleteIndividualCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.individualCustomer.requests.UpdateIndividualCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.individualCustomer.responses.GetAllIndividualCustomersResponse;
import com.tobeto.pair6.rentACar.services.dtos.individualCustomer.responses.GetByIdIndividualCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/individualCustomers")
@AllArgsConstructor
@CrossOrigin
public class IndividualCustomersController {

    private final IndividualCustomerService individualCustomerService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddIndividualCustomerRequest addIndividualCustomerRequest) {

        return this.individualCustomerService.add(addIndividualCustomerRequest);

    }

    @DeleteMapping()
    public Result delete(@RequestBody @Valid DeleteIndividualCustomerRequest deleteIndividualCustomerRequest) {

        return this.individualCustomerService.delete(deleteIndividualCustomerRequest);

    }

    @PutMapping()
    public Result update(@RequestBody @Valid UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {

        return this.individualCustomerService.update(updateIndividualCustomerRequest);

    }

    @GetMapping()
    public DataResult<List<GetAllIndividualCustomersResponse>> getAll() {

        return this.individualCustomerService.getAll();

    }

    @GetMapping("/{id}")
    public DataResult<GetByIdIndividualCustomerResponse> getById(@PathVariable Integer id) {

        return this.individualCustomerService.getById(id);

    }

}
