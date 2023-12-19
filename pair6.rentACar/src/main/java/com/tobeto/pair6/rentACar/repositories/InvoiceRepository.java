package com.tobeto.pair6.rentACar.repositories;

import com.tobeto.pair6.rentACar.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    boolean existsById(int id);


}
