package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair6.rentACar.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.pair6.rentACar.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.pair6.rentACar.services.dtos.brand.responses.GetAllBrandsResponse;
import com.tobeto.pair6.rentACar.services.dtos.brand.responses.GetByIdBrandResponse;
import java.util.List;

public interface BrandService {

    void add(AddBrandRequest addBrandRequest);

    void delete(DeleteBrandRequest deleteBrandRequest);

    void update(UpdateBrandRequest updateBrandRequest);

    List<GetAllBrandsResponse> getAll();

    GetByIdBrandResponse getById(int id);

    boolean getBrandById(int id);

}
