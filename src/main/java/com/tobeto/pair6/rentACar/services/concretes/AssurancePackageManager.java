package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessDataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.pair6.rentACar.entities.concretes.AssurancePackage;
import com.tobeto.pair6.rentACar.repositories.AssurancePackageRepository;
import com.tobeto.pair6.rentACar.services.abstracts.AssurancePackageService;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import com.tobeto.pair6.rentACar.services.dtos.assurancePackage.requests.AddAssurancePackageRequest;
import com.tobeto.pair6.rentACar.services.dtos.assurancePackage.requests.AssuranceRequest;
import com.tobeto.pair6.rentACar.services.dtos.assurancePackage.requests.DeleteAssurancePackageRequest;
import com.tobeto.pair6.rentACar.services.dtos.assurancePackage.requests.UpdateAssurancePackageRequest;
import com.tobeto.pair6.rentACar.services.dtos.assurancePackage.responses.GetAllAssurancePackagesResponse;
import com.tobeto.pair6.rentACar.services.dtos.assurancePackage.responses.GetByIdAssurancePackageResponse;
import com.tobeto.pair6.rentACar.services.rules.AssurancePackageBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AssurancePackageManager implements AssurancePackageService {

    private final AssurancePackageRepository assurancePackageRepository;

    private final ModelMapperService modelMapperService;

    private final AssurancePackageBusinessRules assurancePackageBusinessRules;


    @Override
    public Result add(AddAssurancePackageRequest addAssurancePackageRequest) {

        AssurancePackage assurancePackage = this.modelMapperService.forRequest()
                .map(addAssurancePackageRequest, AssurancePackage.class);
        assurancePackage.setId(null);

        this.assurancePackageRepository.save(assurancePackage);

        return new SuccessResult(Messages.ADD);

    }

    @Override
    public Result delete(DeleteAssurancePackageRequest deleteAssurancePackageRequest) {

        this.assurancePackageBusinessRules.checkIfAssurancePackageByIdExists(deleteAssurancePackageRequest.getId());

        AssurancePackage assurancePackage = this.modelMapperService.forRequest()
                .map(deleteAssurancePackageRequest, AssurancePackage.class);

        this.assurancePackageRepository.delete(assurancePackage);

        return new SuccessResult(Messages.DELETE);

    }

    @Override
    public Result update(UpdateAssurancePackageRequest updateAssurancePackageRequest) {

        this.assurancePackageBusinessRules.checkIfAssurancePackageByIdExists(updateAssurancePackageRequest.getId());

        AssurancePackage assurancePackage = this.modelMapperService.forRequest()
                .map(updateAssurancePackageRequest, AssurancePackage.class);

        this.assurancePackageRepository.save(assurancePackage);

        return new SuccessResult(Messages.UPDATE);

    }

    @Override
    public DataResult<List<GetAllAssurancePackagesResponse>> getAll() {

        List<AssurancePackage> assurancePackages = this.assurancePackageRepository.findAll();

        List<GetAllAssurancePackagesResponse> assurancePackagesResponse = assurancePackages.stream()
                .map(assurancePackage -> this.modelMapperService.forResponse().map(assurancePackage, GetAllAssurancePackagesResponse.class)).toList();

        return new SuccessDataResult<>(assurancePackagesResponse, Messages.GET_ALL);

    }

    @Override
    public DataResult<GetByIdAssurancePackageResponse> getById(Integer id) {

        this.assurancePackageBusinessRules.checkIfAssurancePackageByIdExists(id);

        GetByIdAssurancePackageResponse response = this.modelMapperService.forResponse()
                .map(assurancePackageRepository.findById(id), GetByIdAssurancePackageResponse.class);

        return new SuccessDataResult<>(response, Messages.GET);

    }

    @Override
    public DataResult<GetByIdAssurancePackageResponse> addById(AssuranceRequest assuranceRequest) {

        this.assurancePackageBusinessRules.checkIfAssurancePackageByIdExists(assuranceRequest.getId());

        GetByIdAssurancePackageResponse response = this.modelMapperService.forResponse()
                .map(assurancePackageRepository.findById(assuranceRequest.getId()), GetByIdAssurancePackageResponse.class);

        response.setDailyPrice(this.assurancePackageBusinessRules.
                calculateAssurancePrice(assuranceRequest.getStartDate(), assuranceRequest.getEndDate(), response.getDailyPrice()));

        return new SuccessDataResult<>(response, Messages.ADD);

    }

}
