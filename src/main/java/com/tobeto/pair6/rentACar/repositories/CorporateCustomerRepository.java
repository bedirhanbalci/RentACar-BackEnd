package com.tobeto.pair6.rentACar.repositories;

import com.tobeto.pair6.rentACar.entities.concretes.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer, Integer> {

}
