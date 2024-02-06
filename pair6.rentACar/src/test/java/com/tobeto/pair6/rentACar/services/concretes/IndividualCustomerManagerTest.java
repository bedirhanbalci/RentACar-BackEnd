package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.pair6.rentACar.entities.concretes.IndividualCustomer;
import com.tobeto.pair6.rentACar.repositories.IndividualCustomerRepository;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import com.tobeto.pair6.rentACar.services.dtos.individualCustomer.requests.AddIndividualCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.individualCustomer.requests.DeleteIndividualCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.individualCustomer.requests.UpdateIndividualCustomerRequest;
import com.tobeto.pair6.rentACar.services.rules.IndividualCustomerBusinessRules;
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

class IndividualCustomerManagerTest {

    private IndividualCustomerManager individualCustomerManager;

    @Mock
    private IndividualCustomerRepository individualCustomerRepository;

    @Mock
    private ModelMapperService modelMapperService;

    @Mock
    private IndividualCustomerBusinessRules individualCustomerBusinessRules;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        ModelMapper mockedModelMapper = Mockito.mock(ModelMapper.class);
        Mockito.when(modelMapperService.forRequest()).thenReturn(mockedModelMapper);
        Mockito.when(modelMapperService.forResponse()).thenReturn(mockedModelMapper);
        individualCustomerManager = new IndividualCustomerManager(individualCustomerRepository, modelMapperService, individualCustomerBusinessRules);

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void successfullyAdd() {

        AddIndividualCustomerRequest addIndividualCustomerRequest = new AddIndividualCustomerRequest();
        addIndividualCustomerRequest.setFirstName("Bedirhan");
        addIndividualCustomerRequest.setLastName("Balci");
        addIndividualCustomerRequest.setNationalityNo("00000000000");
        addIndividualCustomerRequest.setUserId(2);

        Mockito.when(modelMapperService.forRequest().map(addIndividualCustomerRequest, IndividualCustomer.class)).thenReturn(new IndividualCustomer());

        Result result = individualCustomerManager.add(addIndividualCustomerRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.ADD, result.getMessage());

    }

    @Test
    void successfullyDelete() {

        DeleteIndividualCustomerRequest deleteIndividualCustomerRequest = new DeleteIndividualCustomerRequest();
        deleteIndividualCustomerRequest.setId(5);

        Mockito.when(modelMapperService.forRequest().map(deleteIndividualCustomerRequest, IndividualCustomer.class)).thenReturn(new IndividualCustomer());

        Result result = individualCustomerManager.delete(deleteIndividualCustomerRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.DELETE, result.getMessage());

    }

    @Test
    void successfullyUpdate() {

        UpdateIndividualCustomerRequest updateIndividualCustomerRequest = new UpdateIndividualCustomerRequest();
        updateIndividualCustomerRequest.setId(5);
        updateIndividualCustomerRequest.setFirstName("Bedirhan");
        updateIndividualCustomerRequest.setLastName("Balci");
        updateIndividualCustomerRequest.setNationalityNo("00000000000");
        updateIndividualCustomerRequest.setUserId(2);


        Mockito.when(modelMapperService.forRequest().map(updateIndividualCustomerRequest, IndividualCustomer.class)).thenReturn(new IndividualCustomer());

        Result result = individualCustomerManager.update(updateIndividualCustomerRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.UPDATE, result.getMessage());

    }

    @Test
    void successfullyGetAll() {

        List<IndividualCustomer> individualCustomers = new ArrayList<>();
        Mockito.when(individualCustomerRepository.findAll()).thenReturn(individualCustomers);
        individualCustomerManager.getAll();
        assert true;

    }

    @Test
    void successfullyGetById() {

        IndividualCustomer individualCustomer = new IndividualCustomer();
        Mockito.when(individualCustomerRepository.findById(individualCustomer.getId())).thenReturn(Optional.of(new IndividualCustomer()));
        individualCustomerManager.getById(individualCustomer.getId());
        assert true;

    }

}