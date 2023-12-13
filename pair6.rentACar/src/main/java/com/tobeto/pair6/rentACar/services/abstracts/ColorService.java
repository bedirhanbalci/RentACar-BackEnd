package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.services.dtos.color.responses.GetByIdColorResponse;

public interface ColorService {
    GetByIdColorResponse getById(int id);
}
