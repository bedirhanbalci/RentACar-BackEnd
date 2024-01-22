package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessDataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.pair6.rentACar.entities.concretes.Invoice;
import com.tobeto.pair6.rentACar.repositories.InvoiceRepository;
import com.tobeto.pair6.rentACar.services.abstracts.InvoiceService;
import com.tobeto.pair6.rentACar.services.dtos.invoice.requests.AddInvoiceRequest;
import com.tobeto.pair6.rentACar.services.dtos.invoice.requests.DeleteInvoiceRequest;
import com.tobeto.pair6.rentACar.services.dtos.invoice.requests.UpdateInvoiceRequest;
import com.tobeto.pair6.rentACar.services.dtos.invoice.responses.GetAllInvoicesResponse;
import com.tobeto.pair6.rentACar.services.dtos.invoice.responses.GetByIdInvoiceResponse;
import com.tobeto.pair6.rentACar.services.rules.InvoiceBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    private final ModelMapperService modelMapperService;

    private final InvoiceBusinessRules invoiceBusinessRules;

    @Override
    public Result add(AddInvoiceRequest addInvoiceRequest) {

        Invoice invoice = this.modelMapperService.forRequest()
                .map(addInvoiceRequest, Invoice.class);
        invoice.setId(null);

        this.invoiceRepository.save(invoice);

        return new SuccessResult("Fatura eklendi!");

    }

    @Override
    public Result delete(DeleteInvoiceRequest deleteInvoiceRequest) {

        this.invoiceBusinessRules.checkIfInvoiceByIdExists(deleteInvoiceRequest.getId());

        Invoice invoice = this.modelMapperService.forRequest()
                .map(deleteInvoiceRequest, Invoice.class);

        this.invoiceRepository.delete(invoice);

        return new SuccessResult("Fatura silindi!");

    }

    @Override
    public Result update(UpdateInvoiceRequest updateInvoiceRequest) {

        this.invoiceBusinessRules.checkIfInvoiceByIdExists(updateInvoiceRequest.getId());

        Invoice invoice = this.modelMapperService.forRequest()
                .map(updateInvoiceRequest, Invoice.class);

        this.invoiceRepository.save(invoice);

        return new SuccessResult("Fatura güncellendi!");

    }

    @Override
    public DataResult<List<GetAllInvoicesResponse>> getAll() {

        List<Invoice> invoices = invoiceRepository.findAll();

        List<GetAllInvoicesResponse> invoicesResponse = invoices.stream()
                .map(invoice -> this.modelMapperService.forResponse().map(invoice, GetAllInvoicesResponse.class)).toList();

        return new SuccessDataResult<>(invoicesResponse, "Tüm faturalar listelendi!");

    }

    @Override
    public DataResult<GetByIdInvoiceResponse> getById(Integer id) {

        this.invoiceBusinessRules.checkIfInvoiceByIdExists(id);

        GetByIdInvoiceResponse response = this.modelMapperService.forResponse()
                .map(invoiceRepository.findById(id), GetByIdInvoiceResponse.class);

        return new SuccessDataResult<>(response, "Fatura listelendi!");

    }

}
