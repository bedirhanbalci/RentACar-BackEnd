package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.dtos.model.requests.AddModelRequest;
import com.tobeto.pair6.rentACar.services.dtos.model.requests.DeleteModelRequest;
import com.tobeto.pair6.rentACar.services.dtos.model.requests.UpdateModelRequest;
import com.tobeto.pair6.rentACar.services.dtos.model.responses.GetAllModelsResponse;
import com.tobeto.pair6.rentACar.services.dtos.model.responses.GetByIdModelResponse;

import java.util.List;

public interface ModelService {

    Result add(AddModelRequest addModelRequest);

    Result delete(DeleteModelRequest deleteModelRequest);

    Result update(UpdateModelRequest updateModelRequest);

    DataResult<List<GetAllModelsResponse>> getAll();

    DataResult<GetByIdModelResponse> getById(Integer id);

    boolean getModelById(Integer id);

}
