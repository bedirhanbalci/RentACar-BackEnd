package com.tobeto.pair6.rentACar.repositories;

import com.tobeto.pair6.rentACar.entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Integer> {

    boolean existsByName(String name);
}
