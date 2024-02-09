package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.dtos.assurancePackage.requests.AddAssurancePackageRequest;
import com.tobeto.pair6.rentACar.services.dtos.assurancePackage.requests.AssuranceRequest;
import com.tobeto.pair6.rentACar.services.dtos.assurancePackage.requests.DeleteAssurancePackageRequest;
import com.tobeto.pair6.rentACar.services.dtos.assurancePackage.requests.UpdateAssurancePackageRequest;
import com.tobeto.pair6.rentACar.services.dtos.assurancePackage.responses.GetAllAssurancePackagesResponse;
import com.tobeto.pair6.rentACar.services.dtos.assurancePackage.responses.GetByIdAssurancePackageResponse;

import java.util.List;

public interface AssurancePackageService {

    Result add(AddAssurancePackageRequest addAssurancePackageRequest);

    Result delete(DeleteAssurancePackageRequest deleteAssurancePackageRequest);

    Result update(UpdateAssurancePackageRequest updateAssurancePackageRequest);

    DataResult<List<GetAllAssurancePackagesResponse>> getAll();

    DataResult<GetByIdAssurancePackageResponse> getById(Integer id);

    DataResult<GetByIdAssurancePackageResponse> addById(AssuranceRequest assuranceRequest);

}
