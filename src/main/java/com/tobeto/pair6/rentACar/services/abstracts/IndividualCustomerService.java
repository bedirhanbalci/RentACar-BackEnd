package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.entities.concretes.IndividualCustomer;
import com.tobeto.pair6.rentACar.services.dtos.individualCustomer.requests.AddIndividualCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.individualCustomer.requests.DeleteIndividualCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.individualCustomer.requests.UpdateIndividualCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.individualCustomer.responses.GetAllIndividualCustomersResponse;
import com.tobeto.pair6.rentACar.services.dtos.individualCustomer.responses.GetByIdIndividualCustomerResponse;

import java.util.List;

public interface IndividualCustomerService {

    Result add(AddIndividualCustomerRequest addIndividualCustomerRequest);

    Result delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest);

    Result update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest);

    DataResult<List<GetAllIndividualCustomersResponse>> getAll();

    DataResult<GetByIdIndividualCustomerResponse> getById(Integer id);

    void addIndividual(IndividualCustomer individualCustomer);

}
