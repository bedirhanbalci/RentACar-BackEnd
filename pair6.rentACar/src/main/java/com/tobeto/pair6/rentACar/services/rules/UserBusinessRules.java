package com.tobeto.pair6.rentACar.services.rules;

import com.tobeto.pair6.rentACar.core.utilities.exceptions.BusinessException;
import com.tobeto.pair6.rentACar.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserBusinessRules {

    private final UserRepository userRepository;

    public void checkIfUserByEmailExists(String email) {
        if (this.userRepository.existsByEmail(email)) {
            throw new BusinessException("Aynı email ile 2. kullanıcı eklenemez!");
        }
    }

    public void checkIfUserByIdExists(Integer id) {
        if (!this.userRepository.existsById(id)) {
            throw new BusinessException("Verilen User Id ile sistemde bir User olmalıdır!");
        }
    }

}