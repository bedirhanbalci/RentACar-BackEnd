package com.tobeto.pair6.rentACar.controllers;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.abstracts.ModelService;
import com.tobeto.pair6.rentACar.services.dtos.model.requests.AddModelRequest;
import com.tobeto.pair6.rentACar.services.dtos.model.requests.DeleteModelRequest;
import com.tobeto.pair6.rentACar.services.dtos.model.requests.UpdateModelRequest;
import com.tobeto.pair6.rentACar.services.dtos.model.responses.GetAllModelsResponse;
import com.tobeto.pair6.rentACar.services.dtos.model.responses.GetByIdModelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
@CrossOrigin
public class ModelsController {

    private final ModelService modelService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddModelRequest addModelRequest) {

        return this.modelService.add(addModelRequest);

    }

    @DeleteMapping()
    public Result delete(@RequestBody @Valid DeleteModelRequest deleteModelRequest) {

        return this.modelService.delete(deleteModelRequest);

    }

    @PutMapping()
    public Result update(@RequestBody @Valid UpdateModelRequest updateModelRequest) {

        return this.modelService.update(updateModelRequest);

    }

    @GetMapping()
    public DataResult<List<GetAllModelsResponse>> getAll() {

        return this.modelService.getAll();

    }

    @GetMapping("/{id}")
    public DataResult<GetByIdModelResponse> getById(@PathVariable Integer id) {

        return this.modelService.getById(id);

    }

}
