package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.services.dtos.invoice.requests.AddInvoiceRequest;
import com.tobeto.pair6.rentACar.services.dtos.invoice.requests.DeleteInvoiceRequest;
import com.tobeto.pair6.rentACar.services.dtos.invoice.requests.UpdateInvoiceRequest;
import com.tobeto.pair6.rentACar.services.dtos.invoice.responses.GetAllInvoicesResponse;
import com.tobeto.pair6.rentACar.services.dtos.invoice.responses.GetByIdInvoiceResponse;

import java.util.List;

public interface InvoiceService {

    void add(AddInvoiceRequest addInvoiceRequest);

    void delete(DeleteInvoiceRequest deleteInvoiceRequest);

    void update(UpdateInvoiceRequest updateInvoiceRequest);

    List<GetAllInvoicesResponse> getAll();

    GetByIdInvoiceResponse getById(int id);
}
