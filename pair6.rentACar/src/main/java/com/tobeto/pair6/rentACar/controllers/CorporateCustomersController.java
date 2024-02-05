package com.tobeto.pair6.rentACar.controllers;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.abstracts.CorporateCustomerService;
import com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.requests.AddCorporateCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.requests.DeleteCorporateCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.requests.UpdateCorporateCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.responses.GetAllCorporateCustomersResponse;
import com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.responses.GetByIdCorporateCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/corporateCustomers")
@AllArgsConstructor
@CrossOrigin
public class CorporateCustomersController {

    private final CorporateCustomerService corporateCustomerService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddCorporateCustomerRequest addCorporateCustomerRequest) {

        return this.corporateCustomerService.add(addCorporateCustomerRequest);

    }

    @DeleteMapping()
    public Result delete(@RequestBody @Valid DeleteCorporateCustomerRequest deleteCorporateCustomerRequest) {

        return this.corporateCustomerService.delete(deleteCorporateCustomerRequest);

    }

    @PutMapping()
    public Result update(@RequestBody @Valid UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {

        return this.corporateCustomerService.update(updateCorporateCustomerRequest);

    }

    @GetMapping()
    public DataResult<List<GetAllCorporateCustomersResponse>> getAll() {

        return this.corporateCustomerService.getAll();

    }

    @GetMapping("/{id}")
    public DataResult<GetByIdCorporateCustomerResponse> getById(@PathVariable Integer id) {

        return this.corporateCustomerService.getById(id);

    }

}
