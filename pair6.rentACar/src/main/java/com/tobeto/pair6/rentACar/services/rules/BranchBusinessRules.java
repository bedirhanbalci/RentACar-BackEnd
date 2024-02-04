package com.tobeto.pair6.rentACar.services.rules;

import com.tobeto.pair6.rentACar.core.utilities.exceptions.BusinessException;
import com.tobeto.pair6.rentACar.repositories.BranchRepository;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BranchBusinessRules {

    private final BranchRepository branchRepository;

    public void checkIfBranchByIdExists(Integer id) {
        if (!this.branchRepository.existsById(id)) {
            throw new BusinessException(Messages.ID_NOT_FOUND);
        }
    }

}
