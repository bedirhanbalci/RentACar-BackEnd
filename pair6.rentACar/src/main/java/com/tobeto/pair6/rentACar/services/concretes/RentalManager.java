package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.entities.Rental;
import com.tobeto.pair6.rentACar.repositories.RentalRepository;
import com.tobeto.pair6.rentACar.services.abstracts.CarService;
import com.tobeto.pair6.rentACar.services.abstracts.RentalService;
import com.tobeto.pair6.rentACar.services.abstracts.UserService;
import com.tobeto.pair6.rentACar.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair6.rentACar.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.pair6.rentACar.services.dtos.rental.requests.DeleteRentalRequest;
import com.tobeto.pair6.rentACar.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.pair6.rentACar.services.dtos.rental.responses.GetAllRentalsResponse;
import com.tobeto.pair6.rentACar.services.dtos.rental.responses.GetByIdRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {

    private final RentalRepository rentalRepository;
    private final ModelMapperService modelMapperService;
    private final CarService carService;
    private final UserService userService;

    @Override
    public void add(AddRentalRequest addRentalRequest) {

        if(!carService.getCarById(addRentalRequest.getCarId())){
            throw new RuntimeException("Verilen Car Id ile sistemde bir araba olmalıdır!");
        }

        if(!userService.getUserById(addRentalRequest.getCarId())){
            throw new RuntimeException("Verilen User Id ile sistemde bir kullanıcı olmalıdır!");
        }

        if (addRentalRequest.getStartDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("Araç kiralarken verilen başlangıç tarihi bugünden daha geçmiş bir tarih olamaz!");
        }

        if (addRentalRequest.getEndDate().isBefore(addRentalRequest.getStartDate())) {
            throw new RuntimeException("Araç kiralarken verilen bitiş tarihi başlangıç tarihinden daha geçmiş bi tarih olamaz!");
        }

        if(ChronoUnit.DAYS.between(addRentalRequest.getStartDate(),addRentalRequest.getEndDate())>25){
            throw new RuntimeException("Bir araç maksimum 25 gün kiralanabilir.");
        }

        Rental rental = this.modelMapperService.forRequest().map(addRentalRequest, Rental.class);

        GetByIdCarResponse carResponse = carService.getById(addRentalRequest.getCarId());
        rental.setStartKilometer(carResponse.getKilometer());

        double totalPrice = carResponse.getDailyPrice();

        Long rentalTime = ChronoUnit.DAYS.between(addRentalRequest.getStartDate(),addRentalRequest.getEndDate());

        totalPrice*= rentalTime;

        rental.setTotalPrice(totalPrice);


        this.rentalRepository.save(rental);
    }

    @Override
    public void delete(DeleteRentalRequest deleteRentalRequest) {

        Rental rental = this.modelMapperService.forRequest().map(deleteRentalRequest, Rental.class);

        this.rentalRepository.delete(rental);

    }

    @Override
    public void update(UpdateRentalRequest updateRentalRequest) {

        if(!carService.getCarById(updateRentalRequest.getCarId())){
            throw new RuntimeException("Verilen Car Id ile sistemde bir araba olmalıdır!");
        }

        if(!userService.getUserById(updateRentalRequest.getCarId())){
            throw new RuntimeException("Verilen User Id ile sistemde bir kullanıcı olmalıdır!");
        }

        Rental rental = this.modelMapperService.forRequest().map(updateRentalRequest, Rental.class);

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

        Rental rental = rentalRepository.findById(id).orElseThrow();

        GetByIdRentalResponse response = this.modelMapperService.forResponse().map(rental, GetByIdRentalResponse.class);
        return response;
    }
}
