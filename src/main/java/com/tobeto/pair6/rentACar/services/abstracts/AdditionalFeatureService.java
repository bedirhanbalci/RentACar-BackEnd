package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.dtos.additionalFeature.requests.AddAdditionalFeatureRequest;
import com.tobeto.pair6.rentACar.services.dtos.additionalFeature.requests.AdditionalRequest;
import com.tobeto.pair6.rentACar.services.dtos.additionalFeature.requests.DeleteAdditionalFeatureRequest;
import com.tobeto.pair6.rentACar.services.dtos.additionalFeature.requests.UpdateAdditionalFeatureRequest;
import com.tobeto.pair6.rentACar.services.dtos.additionalFeature.responses.GetAllAdditionalFeaturesResponse;
import com.tobeto.pair6.rentACar.services.dtos.additionalFeature.responses.GetByIdAdditionalFeatureResponse;

import java.util.List;

public interface AdditionalFeatureService {

    Result add(AddAdditionalFeatureRequest addAdditionalFeatureRequest);

    Result delete(DeleteAdditionalFeatureRequest deleteAdditionalFeatureRequest);

    Result update(UpdateAdditionalFeatureRequest updateAdditionalFeatureRequest);

    DataResult<List<GetAllAdditionalFeaturesResponse>> getAll();

    DataResult<GetByIdAdditionalFeatureResponse> getById(Integer id);

    DataResult<GetByIdAdditionalFeatureResponse> addById(AdditionalRequest additionalRequest);

}
