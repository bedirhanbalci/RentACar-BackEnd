package com.tobeto.pair6.rentACar.services.rules;

import com.tobeto.pair6.rentACar.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserBusinessRules {

    private final UserRepository userRepository;

    public void checkIfUserByEmailExists(String email) {
        if (this.userRepository.existsByEmail(email)) {
            throw new RuntimeException("Aynı email ile 2. kullanıcı eklenemez!");
        }
    }

    public void checkIfUserByIdExists(int id) {
        if (!this.userRepository.existsById(id)) {
            throw new RuntimeException("Verilen User Id ile sistemde bir user olmalıdır!");
        }
}
