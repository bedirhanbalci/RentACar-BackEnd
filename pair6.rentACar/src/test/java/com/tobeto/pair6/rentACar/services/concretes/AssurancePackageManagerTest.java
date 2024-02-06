package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.pair6.rentACar.entities.concretes.AssurancePackage;
import com.tobeto.pair6.rentACar.repositories.AssurancePackageRepository;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import com.tobeto.pair6.rentACar.services.dtos.assurancePackage.requests.AddAssurancePackageRequest;
import com.tobeto.pair6.rentACar.services.dtos.assurancePackage.requests.DeleteAssurancePackageRequest;
import com.tobeto.pair6.rentACar.services.dtos.assurancePackage.requests.UpdateAssurancePackageRequest;
import com.tobeto.pair6.rentACar.services.rules.AssurancePackageBusinessRules;
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

class AssurancePackageManagerTest {

    private AssurancePackageManager assurancePackageManager;

    @Mock
    private AssurancePackageRepository assurancePackageRepository;

    @Mock
    private ModelMapperService modelMapperService;

    @Mock
    private AssurancePackageBusinessRules assurancePackageBusinessRules;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        ModelMapper mockedModelMapper = Mockito.mock(ModelMapper.class);
        Mockito.when(modelMapperService.forRequest()).thenReturn(mockedModelMapper);
        Mockito.when(modelMapperService.forResponse()).thenReturn(mockedModelMapper);
        assurancePackageManager = new AssurancePackageManager(assurancePackageRepository, modelMapperService, assurancePackageBusinessRules);

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void successfullyAdd() {

        AddAssurancePackageRequest addAssurancePackageRequest = new AddAssurancePackageRequest();
        addAssurancePackageRequest.setName("Seat");
        addAssurancePackageRequest.setDetail("Child Seat");
        addAssurancePackageRequest.setDailyPrice(125.5);

        Mockito.when(modelMapperService.forRequest().map(addAssurancePackageRequest, AssurancePackage.class)).thenReturn(new AssurancePackage());

        Result result = assurancePackageManager.add(addAssurancePackageRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.ADD, result.getMessage());

    }

    @Test
    void successfullyDelete() {

        DeleteAssurancePackageRequest deleteAssurancePackageRequest = new DeleteAssurancePackageRequest();
        deleteAssurancePackageRequest.setId(6);

        Mockito.when(modelMapperService.forRequest().map(deleteAssurancePackageRequest, AssurancePackage.class)).thenReturn(new AssurancePackage());

        Result result = assurancePackageManager.delete(deleteAssurancePackageRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.DELETE, result.getMessage());

    }

    @Test
    void successfullyUpdate() {

        UpdateAssurancePackageRequest updateAssurancePackageRequest = new UpdateAssurancePackageRequest();
        updateAssurancePackageRequest.setId(6);
        updateAssurancePackageRequest.setName("Seat");
        updateAssurancePackageRequest.setDetail("Child Seat");
        updateAssurancePackageRequest.setDailyPrice(125.5);

        Mockito.when(modelMapperService.forRequest().map(updateAssurancePackageRequest, AssurancePackage.class)).thenReturn(new AssurancePackage());

        Result result = assurancePackageManager.update(updateAssurancePackageRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.UPDATE, result.getMessage());

    }

    @Test
    void successfullyGetAll() {

        List<AssurancePackage> assurancePackages = new ArrayList<>();
        Mockito.when(assurancePackageRepository.findAll()).thenReturn(assurancePackages);
        assurancePackageManager.getAll();
        assert true;

    }

    @Test
    void successfullyGetById() {

        AssurancePackage assurancePackage = new AssurancePackage();
        Mockito.when(assurancePackageRepository.findById(assurancePackage.getId())).thenReturn(Optional.of(new AssurancePackage()));
        assurancePackageManager.getById(assurancePackage.getId());
        assert true;

    }

}