package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.repositories.ColorRepository;
import com.tobeto.pair6.rentACar.services.abstracts.ColorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {

    private final ColorRepository colorRepository;

    @Override
    public boolean getColorById(int id) {
        return this.colorRepository.existsById(id);
    }
}
