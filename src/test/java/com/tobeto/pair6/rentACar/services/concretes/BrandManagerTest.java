package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.pair6.rentACar.entities.concretes.Brand;
import com.tobeto.pair6.rentACar.repositories.BrandRepository;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import com.tobeto.pair6.rentACar.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.pair6.rentACar.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.pair6.rentACar.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.pair6.rentACar.services.rules.BrandBusinessRules;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BrandManagerTest {

    private BrandManager brandManager;

    @Mock
    private BrandRepository brandRepository;

    @Mock
    private ModelMapperService modelMapperService;

    @Mock
    private BrandBusinessRules brandBusinessRules;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        ModelMapper mockedModelMapper = Mockito.mock(ModelMapper.class);
        Mockito.when(modelMapperService.forRequest()).thenReturn(mockedModelMapper);
        Mockito.when(modelMapperService.forResponse()).thenReturn(mockedModelMapper);
        brandManager = new BrandManager(brandRepository, modelMapperService, brandBusinessRules);

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void nameAlreadyExistsShouldThrowException() {

        AddBrandRequest addBrandRequest = new AddBrandRequest();
        addBrandRequest.setName("Mercedes");

        Mockito.when(brandRepository.existsByName("Mercedes"))
                .thenReturn((true));


        assertThrows(RuntimeException.class, () -> {
            brandManager.add(addBrandRequest);
        });

    }

    @Test
    void successfullyAdd() {

        AddBrandRequest addBrandRequest = new AddBrandRequest();
        addBrandRequest.setName("Mercedes");

        Mockito.when(modelMapperService.forRequest().map(addBrandRequest, Brand.class)).thenReturn(new Brand());

        Result result = brandManager.add(addBrandRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.ADD, result.getMessage());

    }

    @Test
    void successfullyDelete(){

        DeleteBrandRequest deleteBrandRequest = new DeleteBrandRequest();
        deleteBrandRequest.setId(2);

        Mockito.when(modelMapperService.forRequest().map(deleteBrandRequest, Brand.class)).thenReturn(new Brand());

        Result result = brandManager.delete(deleteBrandRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.DELETE, result.getMessage());

    }

    @Test
    void successfullyUpdate() {

        UpdateBrandRequest updateBrandRequest = new UpdateBrandRequest();
        updateBrandRequest.setId(2);
        updateBrandRequest.setName("Mercedes");

        Mockito.when(modelMapperService.forRequest().map(updateBrandRequest, Brand.class)).thenReturn(new Brand());

        Result result = brandManager.update(updateBrandRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.UPDATE, result.getMessage());

    }

    @Test
    void successfullyGetAll(){

        List<Brand> brands = new ArrayList<>();
        Mockito.when(brandRepository.findAll()).thenReturn(brands);
        brandManager.getAll();
        assert true;

    }

    @Test
    void successfullyGetById(){

        Brand brand = new Brand();
        Mockito.when(brandRepository.findById(brand.getId())).thenReturn(Optional.of(new Brand()));
        brandManager.getById(brand.getId());
        assert true;

    }

}


