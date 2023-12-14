package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.repositories.ModelRepository;
import com.tobeto.pair6.rentACar.services.abstracts.ModelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private final ModelRepository modelRepository;

    @Override
    public boolean getModelById(int id) {
        return this.modelRepository.existsById(id);
    }
}
