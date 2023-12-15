package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.entities.Invoice;
import com.tobeto.pair6.rentACar.repositories.InvoiceRepository;
import com.tobeto.pair6.rentACar.services.abstracts.InvoiceService;
import com.tobeto.pair6.rentACar.services.dtos.invoice.requests.AddInvoiceRequest;
import com.tobeto.pair6.rentACar.services.dtos.invoice.requests.DeleteInvoiceRequest;
import com.tobeto.pair6.rentACar.services.dtos.invoice.requests.UpdateInvoiceRequest;
import com.tobeto.pair6.rentACar.services.dtos.invoice.responses.GetAllInvoicesResponse;
import com.tobeto.pair6.rentACar.services.dtos.invoice.responses.GetByIdInvoiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public void add(AddInvoiceRequest addInvoiceRequest) {

        Invoice invoice = this.modelMapperService.forRequest().map(addInvoiceRequest, Invoice.class);

        this.invoiceRepository.save(invoice);
    }

    @Override
    public void delete(DeleteInvoiceRequest deleteInvoiceRequest) {

        Invoice invoice = this.modelMapperService.forRequest().map(deleteInvoiceRequest,Invoice.class);

        this.invoiceRepository.delete(invoice);
    }

    @Override
    public void update(UpdateInvoiceRequest updateInvoiceRequest) {

        Invoice invoice = this.modelMapperService.forRequest().map(updateInvoiceRequest, Invoice.class);

        this.invoiceRepository.save(invoice);

    }

    @Override
    public List<GetAllInvoicesResponse> getAll() {

        List<Invoice> invoices = invoiceRepository.findAll();

        List<GetAllInvoicesResponse> invoicesResponse = invoices.stream()
                .map(invoice -> this.modelMapperService.forResponse().map(invoice, GetAllInvoicesResponse.class)).toList();
        return invoicesResponse;
    }

    @Override
    public GetByIdInvoiceResponse getById(int id) {

        Invoice invoice = invoiceRepository.findById(id).orElseThrow();

        GetByIdInvoiceResponse response = this.modelMapperService.forResponse().map(invoice,GetByIdInvoiceResponse.class);
        return response;
    }
}
