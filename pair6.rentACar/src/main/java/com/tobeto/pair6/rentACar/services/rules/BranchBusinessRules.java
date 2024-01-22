package com.tobeto.pair6.rentACar.services.rules;

import com.tobeto.pair6.rentACar.repositories.BranchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BranchBusinessRules {

    private final BranchRepository branchRepository;

    public void checkIfBranchByIdExists(Integer id) {
        if (!this.branchRepository.existsById(id)) {
            throw new RuntimeException("Verilen Branch Id ile sistemde bir Branch olmalıdır!");
        }
    }

}
