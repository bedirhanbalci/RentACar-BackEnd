package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.pair6.rentACar.entities.concretes.AdditionalFeature;
import com.tobeto.pair6.rentACar.repositories.AdditionalFeatureRepository;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import com.tobeto.pair6.rentACar.services.dtos.additionalFeature.requests.AddAdditionalFeatureRequest;
import com.tobeto.pair6.rentACar.services.dtos.additionalFeature.requests.DeleteAdditionalFeatureRequest;
import com.tobeto.pair6.rentACar.services.dtos.additionalFeature.requests.UpdateAdditionalFeatureRequest;
import com.tobeto.pair6.rentACar.services.rules.AdditionalFeatureBusinessRules;
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

class AdditionalFeatureManagerTest {

    private AdditionalFeatureManager additionalFeatureManager;

    @Mock
    private AdditionalFeatureRepository additionalFeatureRepository;

    @Mock
    private ModelMapperService modelMapperService;

    @Mock
    private AdditionalFeatureBusinessRules additionalFeatureBusinessRules;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        ModelMapper mockedModelMapper = Mockito.mock(ModelMapper.class);
        Mockito.when(modelMapperService.forRequest()).thenReturn(mockedModelMapper);
        Mockito.when(modelMapperService.forResponse()).thenReturn(mockedModelMapper);
        additionalFeatureManager = new AdditionalFeatureManager(additionalFeatureRepository, modelMapperService, additionalFeatureBusinessRules);

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void successfullyAdd() {

        AddAdditionalFeatureRequest addAdditionalFeatureRequest = new AddAdditionalFeatureRequest();
        addAdditionalFeatureRequest.setName("Addition");
        addAdditionalFeatureRequest.setDetail("Driver");
        addAdditionalFeatureRequest.setDailyPrice(101.5);
        addAdditionalFeatureRequest.setQuantity(1);

        Mockito.when(modelMapperService.forRequest().map(addAdditionalFeatureRequest, AdditionalFeature.class)).thenReturn(new AdditionalFeature());

        Result result = additionalFeatureManager.add(addAdditionalFeatureRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.ADD, result.getMessage());

    }

    @Test
    void successfullyDelete() {

        DeleteAdditionalFeatureRequest deleteAdditionalFeatureRequest = new DeleteAdditionalFeatureRequest();
        deleteAdditionalFeatureRequest.setId(5);

        Mockito.when(modelMapperService.forRequest().map(deleteAdditionalFeatureRequest, AdditionalFeature.class)).thenReturn(new AdditionalFeature());

        Result result = additionalFeatureManager.delete(deleteAdditionalFeatureRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.DELETE, result.getMessage());

    }

    @Test
    void successfullyUpdate() {

        UpdateAdditionalFeatureRequest updateAdditionalFeatureRequest = new UpdateAdditionalFeatureRequest();
        updateAdditionalFeatureRequest.setId(5);
        updateAdditionalFeatureRequest.setName("Addition");
        updateAdditionalFeatureRequest.setDetail("Driver");
        updateAdditionalFeatureRequest.setDailyPrice(101.5);
        updateAdditionalFeatureRequest.setQuantity(1);

        Mockito.when(modelMapperService.forRequest().map(updateAdditionalFeatureRequest, AdditionalFeature.class)).thenReturn(new AdditionalFeature());

        Result result = additionalFeatureManager.update(updateAdditionalFeatureRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.UPDATE, result.getMessage());

    }

    @Test
    void successfullyGetAll() {

        List<AdditionalFeature> additionalFeatures = new ArrayList<>();
        Mockito.when(additionalFeatureRepository.findAll()).thenReturn(additionalFeatures);
        additionalFeatureManager.getAll();
        assert true;

    }

    @Test
    void successfullyGetById() {

        AdditionalFeature additionalFeature = new AdditionalFeature();
        Mockito.when(additionalFeatureRepository.findById(additionalFeature.getId())).thenReturn(Optional.of(new AdditionalFeature()));
        additionalFeatureManager.getById(additionalFeature.getId());
        assert true;

    }


}