package com.tobeto.pair6.rentACar.controllers;

import com.tobeto.pair6.rentACar.services.abstracts.InvoiceService;
import com.tobeto.pair6.rentACar.services.dtos.invoice.requests.AddInvoiceRequest;
import com.tobeto.pair6.rentACar.services.dtos.invoice.requests.DeleteInvoiceRequest;
import com.tobeto.pair6.rentACar.services.dtos.invoice.requests.UpdateInvoiceRequest;
import com.tobeto.pair6.rentACar.services.dtos.invoice.responses.GetAllInvoicesResponse;
import com.tobeto.pair6.rentACar.services.dtos.invoice.responses.GetByIdInvoiceResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@AllArgsConstructor
public class InvoicesController {

    private final InvoiceService invoiceService;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddInvoiceRequest addInvoiceRequest){
        invoiceService.add(addInvoiceRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteInvoiceRequest deleteInvoiceRequest){
        invoiceService.delete(deleteInvoiceRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateInvoiceRequest updateInvoiceRequest){
        invoiceService.update(updateInvoiceRequest);
    }

    @GetMapping("/getAll")
    public List<GetAllInvoicesResponse> getAll(){
        return invoiceService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetByIdInvoiceResponse getById(@PathVariable int id){
        return invoiceService.getById(id);
    }
}
