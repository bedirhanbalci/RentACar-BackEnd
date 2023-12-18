package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.entities.Model;
import com.tobeto.pair6.rentACar.repositories.ModelRepository;
import com.tobeto.pair6.rentACar.services.abstracts.ModelService;
import com.tobeto.pair6.rentACar.services.dtos.model.requests.AddModelRequest;
import com.tobeto.pair6.rentACar.services.dtos.model.requests.DeleteModelRequest;
import com.tobeto.pair6.rentACar.services.dtos.model.requests.UpdateModelRequest;
import com.tobeto.pair6.rentACar.services.dtos.model.responses.GetAllModelsResponse;
import com.tobeto.pair6.rentACar.services.dtos.model.responses.GetByIdModelResponse;
import com.tobeto.pair6.rentACar.services.rules.ModelBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private final ModelRepository modelRepository;
    private final ModelMapperService modelMapperService;
    private final ModelBusinessRules modelBusinessRules;

    @Override
    public void add(AddModelRequest addModelRequest) {

        this.modelBusinessRules.checkIfModelByNameExists(addModelRequest.getName());

        this.modelBusinessRules.checkIfBrandByIdExists(addModelRequest.getBrandId());

        Model model = this.modelMapperService.forRequest().map(addModelRequest, Model.class);

        this.modelRepository.save(model);
    }

    @Override
    public void delete(DeleteModelRequest deleteModelRequest) {

        this.modelBusinessRules.checkIfModelByIdExists(deleteModelRequest.getId());

        Model model = this.modelMapperService.forRequest().map(deleteModelRequest, Model.class);

        this.modelRepository.delete(model);

    }

    @Override
    public void update(UpdateModelRequest updateModelRequest) {

        this.modelBusinessRules.checkIfModelByIdExists(updateModelRequest.getId());

        this.modelBusinessRules.checkIfModelByNameExists(updateModelRequest.getName());

        this.modelBusinessRules.checkIfBrandByIdExists(updateModelRequest.getBrandId());

        Model model = this.modelMapperService.forRequest().map(updateModelRequest, Model.class);

        this.modelRepository.save(model);

    }

    @Override
    public List<GetAllModelsResponse> getAll() {

        List<Model> models = modelRepository.findAll();

        List<GetAllModelsResponse> modelsResponse = models.stream()
                .map(model -> this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class)).toList();

        return modelsResponse;
    }

    @Override
    public GetByIdModelResponse getById(int id) {

        this.modelBusinessRules.checkIfModelByIdExists(id);

        GetByIdModelResponse response = this.modelMapperService.forResponse().map(modelRepository.findById(id), GetByIdModelResponse.class);

        return response;
    }

    @Override
    public boolean getModelById(int id) {
        return this.modelRepository.existsById(id);
    }
}
