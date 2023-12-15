package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.entities.Model;
import com.tobeto.pair6.rentACar.repositories.ModelRepository;
import com.tobeto.pair6.rentACar.services.abstracts.BrandService;
import com.tobeto.pair6.rentACar.services.abstracts.ModelService;
import com.tobeto.pair6.rentACar.services.dtos.model.requests.AddModelRequest;
import com.tobeto.pair6.rentACar.services.dtos.model.requests.DeleteModelRequest;
import com.tobeto.pair6.rentACar.services.dtos.model.requests.UpdateModelRequest;
import com.tobeto.pair6.rentACar.services.dtos.model.responses.GetAllModelsResponse;
import com.tobeto.pair6.rentACar.services.dtos.model.responses.GetByIdModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private final ModelRepository modelRepository;
    private final ModelMapperService modelMapperService;
    private final BrandService brandService;
    @Override
    public void add(AddModelRequest addModelRequest) {

        if(this.modelRepository.existsByName(addModelRequest.getName())){
            throw new RuntimeException("Aynı Model 2. kez eklenemez!");
        }

        if(!brandService.getBrandById(addModelRequest.getBrandId())){
            throw new RuntimeException("Verilen Brand Id ile veritabanında bir kayıt bulunmalıdır!");
        }

        Model model = this.modelMapperService.forRequest().map(addModelRequest, Model.class);

        this.modelRepository.save(model);
    }

    @Override
    public void delete(DeleteModelRequest deleteModelRequest) {

        Model model = this.modelMapperService.forRequest().map(deleteModelRequest, Model.class);

        this.modelRepository.delete(model);

    }

    @Override
    public void update(UpdateModelRequest updateModelRequest) {

        if(this.modelRepository.existsByName(updateModelRequest.getName())){
            throw new RuntimeException("Aynı Model 2. kez eklenemez!");
        }

        if(!brandService.getBrandById(updateModelRequest.getBrandId())){
            throw new RuntimeException("Verilen Brand Id ile veritabanında bir kayıt bulunmalıdır!");
        }

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

        Model model = modelRepository.findById(id).orElseThrow();

        GetByIdModelResponse response = this.modelMapperService.forResponse().map(model,GetByIdModelResponse.class);

        return response;
    }

    @Override
    public boolean getModelById(int id) {
        return this.modelRepository.existsById(id);
    }
}
