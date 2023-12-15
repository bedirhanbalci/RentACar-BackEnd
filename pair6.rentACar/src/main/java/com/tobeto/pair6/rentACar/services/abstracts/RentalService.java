package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.pair6.rentACar.services.dtos.rental.requests.DeleteRentalRequest;
import com.tobeto.pair6.rentACar.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.pair6.rentACar.services.dtos.rental.responses.GetAllRentalsResponse;
import com.tobeto.pair6.rentACar.services.dtos.rental.responses.GetByIdRentalResponse;

import java.util.List;

public interface RentalService {

    void add(AddRentalRequest addRentalRequest);

    void delete(DeleteRentalRequest deleteRentalRequest);

    void update(UpdateRentalRequest updateRentalRequest);

    List<GetAllRentalsResponse> getAll();

    GetByIdRentalResponse getById(int id);
}
