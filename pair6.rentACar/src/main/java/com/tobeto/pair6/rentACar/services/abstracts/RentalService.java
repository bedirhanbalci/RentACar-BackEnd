package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.dtos.invoice.responses.GetByIdInvoiceResponse;
import com.tobeto.pair6.rentACar.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.pair6.rentACar.services.dtos.rental.requests.DeleteRentalRequest;
import com.tobeto.pair6.rentACar.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.pair6.rentACar.services.dtos.rental.responses.GetAllRentalsResponse;
import com.tobeto.pair6.rentACar.services.dtos.rental.responses.GetByIdRentalResponse;

import java.util.List;

public interface RentalService {

    GetByIdInvoiceResponse add(AddRentalRequest addRentalRequest);

    Result delete(DeleteRentalRequest deleteRentalRequest);

    Result update(UpdateRentalRequest updateRentalRequest);

    DataResult<List<GetAllRentalsResponse>> getAll();

    DataResult<GetByIdRentalResponse> getById(Integer id);

    void checkIfRentalByDateValid(AddRentalRequest addRentalRequest);

    List<List<Object>> getByUserId(Integer id);
}
