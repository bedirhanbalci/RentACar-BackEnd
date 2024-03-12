package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.dtos.invoice.requests.AddInvoiceRequest;
import com.tobeto.pair6.rentACar.services.dtos.invoice.requests.DeleteInvoiceRequest;
import com.tobeto.pair6.rentACar.services.dtos.invoice.requests.UpdateInvoiceRequest;
import com.tobeto.pair6.rentACar.services.dtos.invoice.responses.GetAllInvoicesResponse;
import com.tobeto.pair6.rentACar.services.dtos.invoice.responses.GetByIdInvoiceResponse;

import java.util.List;

public interface InvoiceService {

    GetByIdInvoiceResponse add(AddInvoiceRequest addInvoiceRequest);

    Result delete(DeleteInvoiceRequest deleteInvoiceRequest);

    Result update(UpdateInvoiceRequest updateInvoiceRequest);

    DataResult<List<GetAllInvoicesResponse>> getAll();

    DataResult<GetByIdInvoiceResponse> getById(Integer id);

    Object findByRentalId(Integer id);

}
