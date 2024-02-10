package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessDataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.pair6.rentACar.entities.concretes.CorporateCustomer;
import com.tobeto.pair6.rentACar.repositories.CorporateCustomerRepository;
import com.tobeto.pair6.rentACar.services.abstracts.CorporateCustomerService;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.requests.AddCorporateCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.requests.DeleteCorporateCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.requests.UpdateCorporateCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.responses.GetAllCorporateCustomersResponse;
import com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.responses.GetByIdCorporateCustomerResponse;
import com.tobeto.pair6.rentACar.services.rules.CorporateCustomerBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CorporateCustomerManager implements CorporateCustomerService {

    private final CorporateCustomerRepository corporateCustomerRepository;

    private final ModelMapperService modelMapperService;

    private final CorporateCustomerBusinessRules corporateCustomerBusinessRules;

    @Override
    public Result add(AddCorporateCustomerRequest addCorporateCustomerRequest) {

        CorporateCustomer corporateCustomer = this.modelMapperService.forRequest()
                .map(addCorporateCustomerRequest, CorporateCustomer.class);
        corporateCustomer.setId(null);

        this.corporateCustomerRepository.save(corporateCustomer);

        return new SuccessResult(Messages.ADD);

    }

    @Override
    public Result delete(DeleteCorporateCustomerRequest deleteCorporateCustomerRequest) {

        this.corporateCustomerBusinessRules.checkIfCorporateCustomerByIdExists(deleteCorporateCustomerRequest.getId());

        CorporateCustomer corporateCustomer = this.modelMapperService.forRequest()
                .map(deleteCorporateCustomerRequest, CorporateCustomer.class);

        this.corporateCustomerRepository.delete(corporateCustomer);

        return new SuccessResult(Messages.DELETE);

    }

    @Override
    public Result update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {

        this.corporateCustomerBusinessRules.checkIfCorporateCustomerByIdExists(updateCorporateCustomerRequest.getId());

        CorporateCustomer corporateCustomer = this.modelMapperService.forRequest()
                .map(updateCorporateCustomerRequest, CorporateCustomer.class);

        this.corporateCustomerRepository.save(corporateCustomer);

        return new SuccessResult(Messages.UPDATE);

    }

    @Override
    public DataResult<List<GetAllCorporateCustomersResponse>> getAll() {

        List<CorporateCustomer> corporateCustomers = this.corporateCustomerRepository.findAll();

        List<GetAllCorporateCustomersResponse> corporateCustomersResponse = corporateCustomers.stream()
                .map(corporateCustomer -> this.modelMapperService.forResponse().map(corporateCustomer, GetAllCorporateCustomersResponse.class)).toList();

        return new SuccessDataResult<>(corporateCustomersResponse, Messages.GET_ALL);

    }

    @Override
    public DataResult<GetByIdCorporateCustomerResponse> getById(Integer id) {

        this.corporateCustomerBusinessRules.checkIfCorporateCustomerByIdExists(id);

        GetByIdCorporateCustomerResponse response = this.modelMapperService.forResponse()
                .map(corporateCustomerRepository.findById(id), GetByIdCorporateCustomerResponse.class);

        return new SuccessDataResult<>(response, Messages.GET);

    }

    @Override
    public void addCorporate(CorporateCustomer corporateCustomer) {

        this.corporateCustomerRepository.save(corporateCustomer);

    }

}
