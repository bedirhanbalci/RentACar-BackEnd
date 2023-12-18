package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.entities.Brand;
import com.tobeto.pair6.rentACar.repositories.BrandRepository;
import com.tobeto.pair6.rentACar.services.abstracts.BrandService;
import com.tobeto.pair6.rentACar.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair6.rentACar.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.pair6.rentACar.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.pair6.rentACar.services.dtos.brand.responses.GetAllBrandsResponse;
import com.tobeto.pair6.rentACar.services.dtos.brand.responses.GetByIdBrandResponse;
import com.tobeto.pair6.rentACar.services.rules.BrandBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;
    private final BrandBusinessRules brandBusinessRules;

    @Override
    public void add(AddBrandRequest addBrandRequest) {

        this.brandBusinessRules.checkIfBrandByNameExists(addBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(addBrandRequest, Brand.class);

        this.brandRepository.save(brand);
    }

    @Override
    public void delete(DeleteBrandRequest deleteBrandRequest) {

        Brand brand = this.modelMapperService.forRequest().map(deleteBrandRequest, Brand.class);

        this.brandRepository.delete(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {

        this.brandBusinessRules.checkIfBrandByNameExists(updateBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);

        this.brandRepository.save(brand);
    }

    @Override
    public List<GetAllBrandsResponse> getAll() {

        List<Brand> brands = brandRepository.findAll();

        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                .map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).toList();
        return brandsResponse;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {

        Brand brand = brandRepository.findById(id).orElseThrow();

        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public boolean getBrandById(int id) {
        return this.brandRepository.existsById(id);
    }
}
