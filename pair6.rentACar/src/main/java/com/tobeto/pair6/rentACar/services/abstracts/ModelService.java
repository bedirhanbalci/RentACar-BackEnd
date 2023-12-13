package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.services.dtos.model.responses.GetByIdModelResponse;

public interface ModelService {
    GetByIdModelResponse getById(int id);
}
