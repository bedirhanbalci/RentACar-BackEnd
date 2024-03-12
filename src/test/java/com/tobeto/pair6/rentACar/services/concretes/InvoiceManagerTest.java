package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.pair6.rentACar.entities.concretes.Invoice;
import com.tobeto.pair6.rentACar.repositories.InvoiceRepository;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import com.tobeto.pair6.rentACar.services.dtos.invoice.requests.AddInvoiceRequest;
import com.tobeto.pair6.rentACar.services.dtos.invoice.requests.DeleteInvoiceRequest;
import com.tobeto.pair6.rentACar.services.dtos.invoice.requests.UpdateInvoiceRequest;
import com.tobeto.pair6.rentACar.services.rules.InvoiceBusinessRules;
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

class InvoiceManagerTest {

    private InvoiceManager invoiceManager;

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private ModelMapperService modelMapperService;

    @Mock
    private InvoiceBusinessRules invoiceBusinessRules;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        ModelMapper mockedModelMapper = Mockito.mock(ModelMapper.class);
        Mockito.when(modelMapperService.forRequest()).thenReturn(mockedModelMapper);
        Mockito.when(modelMapperService.forResponse()).thenReturn(mockedModelMapper);
        invoiceManager = new InvoiceManager(invoiceRepository, modelMapperService, invoiceBusinessRules);

    }

    @AfterEach
    void tearDown() {

    }

//    @Test
//    void successfullyAdd() {
//
//        AddInvoiceRequest addInvoiceRequest = new AddInvoiceRequest();
//        addInvoiceRequest.setInvoiceNo("112");
//        addInvoiceRequest.setRentalId(1);
//
//        Mockito.when(modelMapperService.forRequest().map(addInvoiceRequest, Invoice.class)).thenReturn(new Invoice());
//
//        Result result = invoiceManager.add(addInvoiceRequest);
//
//        assertEquals(SuccessResult.class, result.getClass());
//        assertEquals(Messages.ADD, result.getMessage());
//
//    }

    @Test
    void successfullyDelete() {

        DeleteInvoiceRequest deleteInvoiceRequest = new DeleteInvoiceRequest();
        deleteInvoiceRequest.setId(2);

        Mockito.when(modelMapperService.forRequest().map(deleteInvoiceRequest, Invoice.class)).thenReturn(new Invoice());

        Result result = invoiceManager.delete(deleteInvoiceRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.DELETE, result.getMessage());

    }

    @Test
    void successfullyUpdate() {

        UpdateInvoiceRequest updateInvoiceRequest = new UpdateInvoiceRequest();
        updateInvoiceRequest.setId(2);
        updateInvoiceRequest.setInvoiceNo("112");
        updateInvoiceRequest.setRentalId(1);

        Mockito.when(modelMapperService.forRequest().map(updateInvoiceRequest, Invoice.class)).thenReturn(new Invoice());

        Result result = invoiceManager.update(updateInvoiceRequest);

        assertEquals(SuccessResult.class, result.getClass());
        assertEquals(Messages.UPDATE, result.getMessage());

    }

    @Test
    void successfullyGetAll() {

        List<Invoice> invoices = new ArrayList<>();
        Mockito.when(invoiceRepository.findAll()).thenReturn(invoices);
        invoiceManager.getAll();
        assert true;

    }

    @Test
    void successfullyGetById() {

        Invoice invoice = new Invoice();
        Mockito.when(invoiceRepository.findById(invoice.getId())).thenReturn(Optional.of(new Invoice()));
        invoiceManager.getById(invoice.getId());
        assert true;

    }

}