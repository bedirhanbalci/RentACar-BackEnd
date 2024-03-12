package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.pair6.rentACar.entities.concretes.CorporateCustomer;
import com.tobeto.pair6.rentACar.repositories.CorporateCustomerRepository;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.requests.AddCorporateCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.requests.DeleteCorporateCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.requests.UpdateCorporateCustomerRequest;
import com.tobeto.pair6.rentACar.services.rules.CorporateCustomerBusinessRules;
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

class CorporateCustomerManagerTest {

    private CorporateCustomerManager corporateCustomerManager;

    @Mock
    private CorporateCustomerRepository corporateCustomerRepository;

    @Mock
    private ModelMapperService modelMapperService;

    @Mock
    private CorporateCustomerBusinessRules corporateCustomerBusinessRules;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        ModelMapper mockedModelMapper = Mockito.mock(ModelMapper.class);
        Mockito.when(modelMapperService.forRequest()).thenReturn(mockedModelMapper);
        Mockito.when(modelMapperService.forResponse()).thenReturn(mockedModelMapper);
        corporateCustomerManager = new CorporateCustomerManager(corporateCustomerRepository, modelMapperService, corporateCustomerBusinessRules);

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void successfullyAdd() {

        AddCorporateCustomerRequest addCorporateCustomerRequest = new AddCorporateCustomerRequest();
        addCorporateCustomerRequest.setCompanyName("Tobeto");
        addCorporateCustomerRequest.setContactName("Bedirhan Balci");
        addCorporateCustomerRequest.setContactTitle("Manager");
        addCorporateCustomerRequest.setTaxNumber("1234567890");
        addCorporateCustomerRequest.setUserId(2);

        Mockito.when(modelMapperService.forRequest().map(addCorporateCustomerRequest, CorporateCustomer.class)).thenReturn(new CorporateCustomer());

        Result result = corporateCustomerManager.add(addCorporateCustomerRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.ADD, result.getMessage());

    }

    @Test
    void successfullyDelete() {

        DeleteCorporateCustomerRequest deleteCorporateCustomerRequest = new DeleteCorporateCustomerRequest();
        deleteCorporateCustomerRequest.setId(1);

        Mockito.when(modelMapperService.forRequest().map(deleteCorporateCustomerRequest, CorporateCustomer.class)).thenReturn(new CorporateCustomer());

        Result result = corporateCustomerManager.delete(deleteCorporateCustomerRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.DELETE, result.getMessage());

    }

    @Test
    void successfullyUpdate() {

        UpdateCorporateCustomerRequest updateCorporateCustomerRequest = new UpdateCorporateCustomerRequest();
        updateCorporateCustomerRequest.setId(1);
        updateCorporateCustomerRequest.setCompanyName("Tobeto");
        updateCorporateCustomerRequest.setContactName("Bedirhan Balci");
        updateCorporateCustomerRequest.setContactTitle("Manager");
        updateCorporateCustomerRequest.setTaxNumber("1234567890");
        updateCorporateCustomerRequest.setUserId(3);

        Mockito.when(modelMapperService.forRequest().map(updateCorporateCustomerRequest, CorporateCustomer.class)).thenReturn(new CorporateCustomer());

        Result result = corporateCustomerManager.update(updateCorporateCustomerRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.UPDATE, result.getMessage());

    }

    @Test
    void successfullyGetAll() {

        List<CorporateCustomer> corporateCustomers = new ArrayList<>();
        Mockito.when(corporateCustomerRepository.findAll()).thenReturn(corporateCustomers);
        corporateCustomerManager.getAll();
        assert true;

    }

    @Test
    void successfullyGetById() {

        CorporateCustomer corporateCustomer = new CorporateCustomer();
        Mockito.when(corporateCustomerRepository.findById(corporateCustomer.getId())).thenReturn(Optional.of(new CorporateCustomer()));
        corporateCustomerManager.getById(corporateCustomer.getId());
        assert true;

    }

}