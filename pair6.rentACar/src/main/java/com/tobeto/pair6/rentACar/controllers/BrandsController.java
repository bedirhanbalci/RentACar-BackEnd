package com.tobeto.pair6.rentACar.controllers;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.abstracts.BrandService;
import com.tobeto.pair6.rentACar.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair6.rentACar.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.pair6.rentACar.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.pair6.rentACar.services.dtos.brand.responses.GetAllBrandsResponse;
import com.tobeto.pair6.rentACar.services.dtos.brand.responses.GetByIdBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
@CrossOrigin
public class BrandsController {

    private final BrandService brandService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddBrandRequest addBrandRequest) {

        return this.brandService.add(addBrandRequest);

    }

    @DeleteMapping()
    public Result delete(@RequestBody @Valid DeleteBrandRequest deleteBrandRequest) {

        return this.brandService.delete(deleteBrandRequest);

    }

    @PutMapping()
    public Result update(@RequestBody @Valid UpdateBrandRequest updateBrandRequest) {

        return this.brandService.update(updateBrandRequest);

    }

    @GetMapping()
    public DataResult<List<GetAllBrandsResponse>> getAll() {

        return this.brandService.getAll();

    }

    @GetMapping("/{id}")
    public DataResult<GetByIdBrandResponse> getById(@PathVariable Integer id) {

        return this.brandService.getById(id);

    }

}
