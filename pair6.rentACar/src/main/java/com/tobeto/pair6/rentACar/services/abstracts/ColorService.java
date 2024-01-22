package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.dtos.color.requests.AddColorRequest;
import com.tobeto.pair6.rentACar.services.dtos.color.requests.DeleteColorRequest;
import com.tobeto.pair6.rentACar.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.pair6.rentACar.services.dtos.color.responses.GetAllColorsResponse;
import com.tobeto.pair6.rentACar.services.dtos.color.responses.GetByIdColorResponse;

import java.util.List;

public interface ColorService {

    Result add(AddColorRequest addColorRequest);

    Result delete(DeleteColorRequest deleteColorRequest);

    Result update(UpdateColorRequest updateColorRequest);

    DataResult<List<GetAllColorsResponse>> getAll();

    DataResult<GetByIdColorResponse> getById(Integer id);

    boolean getColorById(Integer id);

}
