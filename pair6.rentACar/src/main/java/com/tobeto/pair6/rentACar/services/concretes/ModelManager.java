package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.entities.Model;
import com.tobeto.pair6.rentACar.services.abstracts.ModelService;
import com.tobeto.pair6.rentACar.services.dtos.model.responses.GetByIdModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    @Override
    public GetByIdModelResponse getById(int id) {
        return null;
    }
}
