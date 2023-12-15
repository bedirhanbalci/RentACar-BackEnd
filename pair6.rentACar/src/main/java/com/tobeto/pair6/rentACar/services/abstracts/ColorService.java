package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.services.dtos.color.requests.AddColorRequest;
import com.tobeto.pair6.rentACar.services.dtos.color.requests.DeleteColorRequest;
import com.tobeto.pair6.rentACar.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.pair6.rentACar.services.dtos.color.responses.GetAllColorsResponse;
import com.tobeto.pair6.rentACar.services.dtos.color.responses.GetByIdColorResponse;

import java.util.List;

public interface ColorService {

    void add(AddColorRequest addColorRequest);

    void delete(DeleteColorRequest deleteColorRequest);

    void update(UpdateColorRequest updateColorRequest);

    List<GetAllColorsResponse> getAll();

    GetByIdColorResponse getById(int id);

    boolean getColorById(int id);
}
