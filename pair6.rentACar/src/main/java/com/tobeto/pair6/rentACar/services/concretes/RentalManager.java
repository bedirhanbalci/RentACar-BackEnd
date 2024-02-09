package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.core.utilities.results.*;
import com.tobeto.pair6.rentACar.entities.concretes.Rental;
import com.tobeto.pair6.rentACar.repositories.RentalRepository;
import com.tobeto.pair6.rentACar.services.abstracts.*;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import com.tobeto.pair6.rentACar.services.dtos.additionalFeature.requests.AdditionalRequest;
import com.tobeto.pair6.rentACar.services.dtos.assurancePackage.requests.AssuranceRequest;
import com.tobeto.pair6.rentACar.services.dtos.car.responses.GetByIdCarResponse;
import com.tobeto.pair6.rentACar.services.dtos.invoice.requests.AddInvoiceRequest;
import com.tobeto.pair6.rentACar.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.pair6.rentACar.services.dtos.rental.requests.AdditionalModel;
import com.tobeto.pair6.rentACar.services.dtos.rental.requests.DeleteRentalRequest;
import com.tobeto.pair6.rentACar.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.pair6.rentACar.services.dtos.rental.responses.GetAllRentalsResponse;
import com.tobeto.pair6.rentACar.services.dtos.rental.responses.GetByIdRentalResponse;
import com.tobeto.pair6.rentACar.services.rules.AdditionalFeatureBusinessRules;
import com.tobeto.pair6.rentACar.services.rules.AssurancePackageBusinessRules;
import com.tobeto.pair6.rentACar.services.rules.RentalBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {

    private final RentalRepository rentalRepository;

    private final CarService carService;

    private final ModelMapperService modelMapperService;

    private final RentalBusinessRules rentalBusinessRules;

    private final AdditionalFeatureService additionalFeatureService;

    private final AssurancePackageService assurancePackageService;

    private final InvoiceService invoiceService;

    @Override
    public Result add(AddRentalRequest addRentalRequest) {

        this.rentalBusinessRules.checkIfCarByIdExists(addRentalRequest.getCarId());

        this.rentalBusinessRules.checkIfUserByIdExists(addRentalRequest.getUserId());

        this.rentalBusinessRules.checkIfRentalByStartDate(addRentalRequest.getStartDate());

        this.rentalBusinessRules.checkIfRentalByEndDate(addRentalRequest.getEndDate(), addRentalRequest.getStartDate());

        this.rentalBusinessRules.checkIfRentalByDateValid(addRentalRequest.getStartDate(), addRentalRequest.getEndDate());

        Rental rental = this.modelMapperService.forRequest()
                .map(addRentalRequest, Rental.class);
        rental.setId(null);

        DataResult<GetByIdCarResponse> carResponse = carService.getById(addRentalRequest.getCarId());

        rental.setStartKilometer(carResponse.getData().getKilometer());

        Double carPrice = this.rentalBusinessRules.calculateTotalPrice(addRentalRequest.getStartDate(), addRentalRequest.getEndDate(), carResponse.getData().getDailyPrice());

        Double totalPrice = 0.0;
        totalPrice += carPrice;

        Double assurancePrice = this.assurancePackageService.addById(new AssuranceRequest(addRentalRequest.getAssurancePackageId(), addRentalRequest.getStartDate(), addRentalRequest.getEndDate())).getData().getDailyPrice();

        totalPrice += assurancePrice;

        Double additionalPrice = 0.0;


        for (AdditionalModel additionalModel : addRentalRequest.getAdditionalList()) {

            additionalPrice += this.additionalFeatureService.addById(new AdditionalRequest(additionalModel.getId(), addRentalRequest.getStartDate(), addRentalRequest.getEndDate(), additionalModel.getQuantity())).getData().getDailyPrice();

        }

        totalPrice += additionalPrice;

        rental.setTotalPrice(totalPrice);

        Rental savedRental = this.rentalRepository.save(rental);

        this.invoiceService.add(new AddInvoiceRequest(UUID.randomUUID().toString(), savedRental.getId()));

        return new SuccessResult(Messages.ADD);

    }

    @Override
    public Result delete(DeleteRentalRequest deleteRentalRequest) {

        this.rentalBusinessRules.checkIfRentalByIdExists(deleteRentalRequest.getId());

        Rental rental = this.modelMapperService.forRequest()
                .map(deleteRentalRequest, Rental.class);

        this.rentalRepository.delete(rental);

        return new SuccessResult(Messages.DELETE);

    }

    @Override
    public Result update(UpdateRentalRequest updateRentalRequest) {

        this.rentalBusinessRules.checkIfRentalByIdExists(updateRentalRequest.getId());

        this.rentalBusinessRules.checkIfCarByIdExists(updateRentalRequest.getCarId());

        this.rentalBusinessRules.checkIfUserByIdExists(updateRentalRequest.getUserId());

        this.rentalBusinessRules.checkIfRentalByStartDate(updateRentalRequest.getStartDate());

        this.rentalBusinessRules.checkIfRentalByEndDate(updateRentalRequest.getEndDate(), updateRentalRequest.getStartDate());

        this.rentalBusinessRules.checkIfRentalByDateValid(updateRentalRequest.getStartDate(), updateRentalRequest.getEndDate());

        Rental rental = this.modelMapperService.forRequest()
                .map(updateRentalRequest, Rental.class);

        DataResult<GetByIdCarResponse> carResponse = carService.getById(updateRentalRequest.getCarId());

        rental.setStartKilometer(carResponse.getData().getKilometer());

        rental.setTotalPrice(this.rentalBusinessRules.calculateTotalPrice(updateRentalRequest.getStartDate(), updateRentalRequest.getEndDate(), carResponse.getData().getDailyPrice()));

        this.rentalRepository.save(rental);

        return new SuccessResult(Messages.UPDATE);

    }

    @Override
    public DataResult<List<GetAllRentalsResponse>> getAll() {

        List<Rental> rentals = rentalRepository.findAll();

        List<GetAllRentalsResponse> rentalsResponse = rentals.stream()
                .map(rental -> this.modelMapperService.forResponse().map(rental, GetAllRentalsResponse.class)).toList();

        return new SuccessDataResult<>(rentalsResponse, Messages.GET_ALL);

    }

    @Override
    public DataResult<GetByIdRentalResponse> getById(Integer id) {

        this.rentalBusinessRules.checkIfRentalByIdExists(id);

        GetByIdRentalResponse response = this.modelMapperService.forResponse()
                .map(rentalRepository.findById(id), GetByIdRentalResponse.class);

        return new SuccessDataResult<>(response, Messages.GET);

    }

}
