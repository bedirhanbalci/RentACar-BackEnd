package com.tobeto.pair6.rentACar.controllers;

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
public class BrandsController {

    private final BrandService brandService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddBrandRequest addBrandRequest) {
        brandService.add(addBrandRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody @Valid DeleteBrandRequest deleteBrandRequest) {
        brandService.delete(deleteBrandRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateBrandRequest updateBrandRequest) {
        brandService.update(updateBrandRequest);
    }

    @GetMapping("/getAll")
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id) {
        return brandService.getById(id);
    }
}
