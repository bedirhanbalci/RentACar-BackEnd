package com.tobeto.pair6.rentACar.services.rules;

import com.tobeto.pair6.rentACar.repositories.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvoiceBusinessRules {

    private final InvoiceRepository invoiceRepository;

    public void checkIfInvoiceByIdExists(int id) {
        if (!this.invoiceRepository.existsById(id)) {
            throw new RuntimeException("Verilen İnvoice Id ile sistemde bir invoice olmalıdır!");
        }
    }
}
