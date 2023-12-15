package com.tobeto.pair6.rentACar.controllers;

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
public class ModelsController {

    private final ModelService modelService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddModelRequest addModelRequest){
        modelService.add(addModelRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteModelRequest deleteModelRequest){
        modelService.delete(deleteModelRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateModelRequest updateModelRequest){
        modelService.update(updateModelRequest);
    }

    @GetMapping("/getAll")
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetByIdModelResponse getById(@PathVariable int id){
        return modelService.getById(id);
    }
}
