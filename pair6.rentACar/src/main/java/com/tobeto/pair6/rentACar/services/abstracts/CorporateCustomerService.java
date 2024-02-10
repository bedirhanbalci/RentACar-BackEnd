package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.entities.concretes.CorporateCustomer;
import com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.requests.AddCorporateCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.requests.DeleteCorporateCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.requests.UpdateCorporateCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.responses.GetAllCorporateCustomersResponse;
import com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.responses.GetByIdCorporateCustomerResponse;

import java.util.List;

public interface CorporateCustomerService {

    Result add(AddCorporateCustomerRequest addCorporateCustomerRequest);

    Result delete(DeleteCorporateCustomerRequest deleteCorporateCustomerRequest);

    Result update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest);

    DataResult<List<GetAllCorporateCustomersResponse>> getAll();

    DataResult<GetByIdCorporateCustomerResponse> getById(Integer id);

    void addCorporate(CorporateCustomer corporateCustomer);

}
