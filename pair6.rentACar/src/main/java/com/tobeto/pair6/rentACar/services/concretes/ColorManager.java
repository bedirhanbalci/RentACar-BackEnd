package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.entities.Color;
import com.tobeto.pair6.rentACar.services.abstracts.ColorService;
import com.tobeto.pair6.rentACar.services.dtos.color.responses.GetByIdColorResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {

    @Override
    public GetByIdColorResponse getById(int id) {
        return null;
    }
}
