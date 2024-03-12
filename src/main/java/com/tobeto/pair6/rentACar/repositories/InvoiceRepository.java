package com.tobeto.pair6.rentACar.repositories;

import com.tobeto.pair6.rentACar.entities.concretes.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
       Object findByRentalId(Integer id);

}
