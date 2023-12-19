package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.entities.Rental;
import com.tobeto.pair6.rentACar.repositories.RentalRepository;
import com.tobeto.pair6.rentACar.services.abstracts.CarService;
import com.tobeto.pair6.rentACar.services.abstracts.RentalService;
import com.tobeto.pair6.rentACar.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair6.rentACar.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.pair6.rentACar.services.dtos.rental.requests.DeleteRentalRequest;
import com.tobeto.pair6.rentACar.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.pair6.rentACar.services.dtos.rental.responses.GetAllRentalsResponse;
import com.tobeto.pair6.rentACar.services.dtos.rental.responses.GetByIdRentalResponse;
import com.tobeto.pair6.rentACar.services.rules.RentalBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {

    private final RentalRepository rentalRepository;
    private final ModelMapperService modelMapperService;
    private final CarService carService;
    private final RentalBusinessRules rentalBusinessRules;

    @Override
    public void add(AddRentalRequest addRentalRequest) {

        this.rentalBusinessRules.checkIfCarByIdExists(addRentalRequest.getCarId());

        this.rentalBusinessRules.checkIfUserByIdExists(addRentalRequest.getUserId());

        this.rentalBusinessRules.checkIfRentalByStartDate(addRentalRequest.getStartDate());

        this.rentalBusinessRules.checkIfRentalByEndDate(addRentalRequest.getEndDate(), addRentalRequest.getStartDate());

        this.rentalBusinessRules.checkIfRentalByDateValid(addRentalRequest.getStartDate(), addRentalRequest.getEndDate());


        Rental rental = this.modelMapperService.forRequest().map(addRentalRequest, Rental.class);

        GetByIdCarResponse carResponse = carService.getById(addRentalRequest.getCarId());
        rental.setStartKilometer(carResponse.getKilometer());

        rental.setTotalPrice(this.rentalBusinessRules.calculateTotalPrice(addRentalRequest.getStartDate(), addRentalRequest.getEndDate(), carResponse.getDailyPrice()));

        this.rentalRepository.save(rental);
    }

    @Override
    public void delete(DeleteRentalRequest deleteRentalRequest) {

        this.rentalBusinessRules.checkIfRentalByIdExists(deleteRentalRequest.getId());

        Rental rental = this.modelMapperService.forRequest().map(deleteRentalRequest, Rental.class);

        this.rentalRepository.delete(rental);

    }

    @Override
    public void update(UpdateRentalRequest updateRentalRequest) {

        this.rentalBusinessRules.checkIfRentalByIdExists(updateRentalRequest.getId());

        this.rentalBusinessRules.checkIfCarByIdExists(updateRentalRequest.getCarId());

        this.rentalBusinessRules.checkIfUserByIdExists(updateRentalRequest.getUserId());

        Rental rental = this.modelMapperService.forRequest().map(updateRentalRequest, Rental.class);

        GetByIdCarResponse carResponse = carService.getById(updateRentalRequest.getCarId());
        rental.setStartKilometer(carResponse.getKilometer());

        rental.setTotalPrice(this.rentalBusinessRules.calculateTotalPrice(updateRentalRequest.getStartDate(), updateRentalRequest.getEndDate(), carResponse.getDailyPrice()));

        this.rentalRepository.save(rental);
    }

    @Override
    public List<GetAllRentalsResponse> getAll() {

        List<Rental> rentals = rentalRepository.findAll();

        List<GetAllRentalsResponse> rentalsResponse = rentals.stream()
                .map(rental -> this.modelMapperService.forResponse().map(rental, GetAllRentalsResponse.class)).toList();
        return rentalsResponse;
    }

    @Override
    public GetByIdRentalResponse getById(int id) {

        this.rentalBusinessRules.checkIfRentalByIdExists(id);

        GetByIdRentalResponse response = this.modelMapperService.forResponse().map(rentalRepository.findById(id), GetByIdRentalResponse.class);
        return response;
    }
}
