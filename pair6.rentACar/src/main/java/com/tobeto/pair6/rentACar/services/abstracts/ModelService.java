package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.services.dtos.model.requests.AddModelRequest;
import com.tobeto.pair6.rentACar.services.dtos.model.requests.DeleteModelRequest;
import com.tobeto.pair6.rentACar.services.dtos.model.requests.UpdateModelRequest;
import com.tobeto.pair6.rentACar.services.dtos.model.responses.GetAllModelsResponse;
import com.tobeto.pair6.rentACar.services.dtos.model.responses.GetByIdModelResponse;
import java.util.List;

public interface ModelService {

    void add(AddModelRequest addModelRequest);

    void delete(DeleteModelRequest deleteModelRequest);

    void update(UpdateModelRequest updateModelRequest);

    List<GetAllModelsResponse> getAll();

    GetByIdModelResponse getById(int id);

    boolean getModelById(int id);
}
