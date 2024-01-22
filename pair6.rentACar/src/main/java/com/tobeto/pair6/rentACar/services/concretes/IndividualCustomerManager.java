package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessDataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.pair6.rentACar.entities.concretes.IndividualCustomer;
import com.tobeto.pair6.rentACar.repositories.IndividualCustomerRepository;
import com.tobeto.pair6.rentACar.services.abstracts.IndividualCustomerService;
import com.tobeto.pair6.rentACar.services.dtos.individualCustomer.requests.AddIndividualCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.individualCustomer.requests.DeleteIndividualCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.individualCustomer.requests.UpdateIndividualCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.individualCustomer.responses.GetAllIndividualCustomersResponse;
import com.tobeto.pair6.rentACar.services.dtos.individualCustomer.responses.GetByIdIndividualCustomerResponse;
import com.tobeto.pair6.rentACar.services.rules.IndividualCustomerBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {

    private final IndividualCustomerRepository individualCustomerRepository;

    private final ModelMapperService modelMapperService;

    private final IndividualCustomerBusinessRules individualCustomerBusinessRules;

    @Override
    public Result add(AddIndividualCustomerRequest addIndividualCustomerRequest) {

        IndividualCustomer individualCustomer = this.modelMapperService.forRequest()
                .map(addIndividualCustomerRequest, IndividualCustomer.class);
        individualCustomer.setId(null);

        this.individualCustomerRepository.save(individualCustomer);

        return new SuccessResult("Bireysel müşteri eklendi!");

    }

    @Override
    public Result delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest) {

        this.individualCustomerBusinessRules.checkIfIndividualCustomerByIdExists(deleteIndividualCustomerRequest.getId());

        IndividualCustomer individualCustomer = this.modelMapperService.forRequest()
                .map(deleteIndividualCustomerRequest, IndividualCustomer.class);

        this.individualCustomerRepository.delete(individualCustomer);

        return new SuccessResult("Bireysel müşteri silindi!");

    }

    @Override
    public Result update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {

        this.individualCustomerBusinessRules.checkIfIndividualCustomerByIdExists(updateIndividualCustomerRequest.getId());

        IndividualCustomer individualCustomer = this.modelMapperService.forRequest()
                .map(updateIndividualCustomerRequest, IndividualCustomer.class);

        this.individualCustomerRepository.save(individualCustomer);

        return new SuccessResult("Bireysel müşteri güncellendi!");

    }

    @Override
    public DataResult<List<GetAllIndividualCustomersResponse>> getAll() {

        List<IndividualCustomer> individualCustomers = this.individualCustomerRepository.findAll();

        List<GetAllIndividualCustomersResponse> individualCustomersResponse = individualCustomers.stream()
                .map(individualCustomer -> this.modelMapperService.forResponse().map(individualCustomer, GetAllIndividualCustomersResponse.class)).toList();

        return new SuccessDataResult<>(individualCustomersResponse, "Tüm bireysel müşteriler listelendi!");

    }

    @Override
    public DataResult<GetByIdIndividualCustomerResponse> getById(Integer id) {

        this.individualCustomerBusinessRules.checkIfIndividualCustomerByIdExists(id);

        GetByIdIndividualCustomerResponse response = this.modelMapperService.forResponse()
                .map(individualCustomerRepository.findById(id), GetByIdIndividualCustomerResponse.class);

        return new SuccessDataResult<>(response, "Bireysel müşteri listelendi!");

    }

}
