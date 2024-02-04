package com.tobeto.pair6.rentACar.services.rules;

import com.tobeto.pair6.rentACar.core.utilities.exceptions.BusinessException;
import com.tobeto.pair6.rentACar.repositories.ColorRepository;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ColorBusinessRules {

    private final ColorRepository colorRepository;

    public void checkIfColorByNameExists(String name) {
        if (this.colorRepository.existsByName(name)) {
            throw new BusinessException(Messages.COLOR_ALREADY_EXISTS);
        }
    }

    public void checkIfColorByIdExists(Integer id) {
        if (!this.colorRepository.existsById(id)) {
            throw new BusinessException(Messages.ID_NOT_FOUND);
        }
    }

}
