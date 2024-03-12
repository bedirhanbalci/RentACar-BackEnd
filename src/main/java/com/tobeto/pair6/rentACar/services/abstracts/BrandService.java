package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair6.rentACar.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.pair6.rentACar.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.pair6.rentACar.services.dtos.brand.responses.GetAllBrandsResponse;
import com.tobeto.pair6.rentACar.services.dtos.brand.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {

    Result add(AddBrandRequest addBrandRequest);

    Result delete(DeleteBrandRequest deleteBrandRequest);

    Result update(UpdateBrandRequest updateBrandRequest);

    DataResult<List<GetAllBrandsResponse>> getAll();

    DataResult<GetByIdBrandResponse> getById(Integer id);

    boolean getBrandById(Integer id);

}
