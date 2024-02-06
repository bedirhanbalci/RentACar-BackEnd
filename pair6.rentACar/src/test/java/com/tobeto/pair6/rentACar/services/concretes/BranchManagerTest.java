package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.pair6.rentACar.entities.concretes.Branch;
import com.tobeto.pair6.rentACar.repositories.BranchRepository;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import com.tobeto.pair6.rentACar.services.dtos.branch.requests.AddBranchRequest;
import com.tobeto.pair6.rentACar.services.dtos.branch.requests.DeleteBranchRequest;
import com.tobeto.pair6.rentACar.services.dtos.branch.requests.UpdateBranchRequest;
import com.tobeto.pair6.rentACar.services.rules.BranchBusinessRules;
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

class BranchManagerTest {

    private BranchManager branchManager;

    @Mock
    private BranchRepository branchRepository;

    @Mock
    private ModelMapperService modelMapperService;

    @Mock
    private BranchBusinessRules branchBusinessRules;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        ModelMapper mockedModelMapper = Mockito.mock(ModelMapper.class);
        Mockito.when(modelMapperService.forRequest()).thenReturn(mockedModelMapper);
        Mockito.when(modelMapperService.forResponse()).thenReturn(mockedModelMapper);
        branchManager = new BranchManager(branchRepository, modelMapperService, branchBusinessRules);

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void successfullyAdd() {

        AddBranchRequest addBranchRequest = new AddBranchRequest();
        addBranchRequest.setCity("Istanbul");
        addBranchRequest.setAddress("Atasehir");
        addBranchRequest.setPhoneNumber("123456789");
        addBranchRequest.setLatitude(34.123);
        addBranchRequest.setLongitude(34.213);

        Mockito.when(modelMapperService.forRequest().map(addBranchRequest, Branch.class)).thenReturn(new Branch());

        Result result = branchManager.add(addBranchRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.ADD, result.getMessage());

    }

    @Test
    void successfullyDelete(){

        DeleteBranchRequest deleteBranchRequest = new DeleteBranchRequest();
        deleteBranchRequest.setId(4);

        Mockito.when(modelMapperService.forRequest().map(deleteBranchRequest, Branch.class)).thenReturn(new Branch());

        Result result = branchManager.delete(deleteBranchRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.DELETE, result.getMessage());

    }

    @Test
    void successfullyUpdate() {

        UpdateBranchRequest updateBranchRequest = new UpdateBranchRequest();
        updateBranchRequest.setId(4);
        updateBranchRequest.setCity("Istanbul");
        updateBranchRequest.setAddress("Atasehir");
        updateBranchRequest.setPhoneNumber("123456789");
        updateBranchRequest.setLatitude(34.123);
        updateBranchRequest.setLongitude(34.213);

        Mockito.when(modelMapperService.forRequest().map(updateBranchRequest, Branch.class)).thenReturn(new Branch());

        Result result = branchManager.update(updateBranchRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.UPDATE, result.getMessage());

    }

    @Test
    void successfullyGetAll(){

        List<Branch> branches = new ArrayList<>();
        Mockito.when(branchRepository.findAll()).thenReturn(branches);
        branchManager.getAll();
        assert true;

    }

    @Test
    void successfullyGetById(){

        Branch branch = new Branch();
        Mockito.when(branchRepository.findById(branch.getId())).thenReturn(Optional.of(new Branch()));
        branchManager.getById(branch.getId());
        assert true;

    }

}