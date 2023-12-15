package com.tobeto.pair6.rentACar.controllers;

import com.tobeto.pair6.rentACar.services.abstracts.RentalService;
import com.tobeto.pair6.rentACar.services.dtos.brand.responses.GetAllBrandsResponse;
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
public class RentalsController {

    private final RentalService rentalService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddRentalRequest addRentalRequest){
        rentalService.add(addRentalRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteRentalRequest deleteRentalRequest){
        rentalService.delete(deleteRentalRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateRentalRequest updateRentalRequest){
        rentalService.update(updateRentalRequest);
    }

    @GetMapping("/getAll")
    public List<GetAllRentalsResponse> getAll(){
        return rentalService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetByIdRentalResponse getById(@PathVariable int id){
        return rentalService.getById(id);
    }

}
