package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessDataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.pair6.rentACar.entities.concretes.Brand;
import com.tobeto.pair6.rentACar.repositories.BrandRepository;
import com.tobeto.pair6.rentACar.services.abstracts.BrandService;
import com.tobeto.pair6.rentACar.services.constants.Messages;
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
    public Result add(AddBrandRequest addBrandRequest) {

        this.brandBusinessRules.checkIfBrandByNameExists(addBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest()
                .map(addBrandRequest, Brand.class);
        brand.setId(null);

        this.brandRepository.save(brand);

        return new SuccessResult(Messages.ADD);

    }

    @Override
    public Result delete(DeleteBrandRequest deleteBrandRequest) {

        this.brandBusinessRules.checkIfBrandByIdExists(deleteBrandRequest.getId());

        Brand brand = this.modelMapperService.forRequest()
                .map(deleteBrandRequest, Brand.class);

        this.brandRepository.delete(brand);

        return new SuccessResult(Messages.DELETE);

    }

    @Override
    public Result update(UpdateBrandRequest updateBrandRequest) {

        this.brandBusinessRules.checkIfBrandByIdExists(updateBrandRequest.getId());

        this.brandBusinessRules.checkIfBrandByNameExists(updateBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest()
                .map(updateBrandRequest, Brand.class);

        this.brandRepository.save(brand);

        return new SuccessResult(Messages.UPDATE);

    }

    @Override
    public DataResult<List<GetAllBrandsResponse>> getAll() {

        List<Brand> brands = brandRepository.findAll();

        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                .map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).toList();

        return new SuccessDataResult<>(brandsResponse, Messages.GET_ALL);

    }

    @Override
    public DataResult<GetByIdBrandResponse> getById(Integer id) {

        this.brandBusinessRules.checkIfBrandByIdExists(id);

        GetByIdBrandResponse response = this.modelMapperService.forResponse()
                .map(brandRepository.findById(id), GetByIdBrandResponse.class);

        return new SuccessDataResult<>(response, Messages.GET);

    }

    @Override
    public boolean getBrandById(Integer id) {

        return this.brandRepository.existsById(id);

    }

}
