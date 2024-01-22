package com.tobeto.pair6.rentACar.controllers;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
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
@CrossOrigin
public class InvoicesController {

    private final InvoiceService invoiceService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddInvoiceRequest addInvoiceRequest) {

        return this.invoiceService.add(addInvoiceRequest);

    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody @Valid DeleteInvoiceRequest deleteInvoiceRequest) {

        return this.invoiceService.delete(deleteInvoiceRequest);

    }

    @PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateInvoiceRequest updateInvoiceRequest) {

        return this.invoiceService.update(updateInvoiceRequest);

    }

    @GetMapping("/getAll")
    public DataResult<List<GetAllInvoicesResponse>> getAll() {

        return this.invoiceService.getAll();

    }

    @GetMapping("/getById/{id}")
    public DataResult<GetByIdInvoiceResponse> getById(@PathVariable Integer id) {

        return this.invoiceService.getById(id);

    }

}
