package com.tobeto.pair6.rentACar.controllers;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.abstracts.AdditionalFeatureService;
import com.tobeto.pair6.rentACar.services.dtos.additionalFeature.requests.AddAdditionalFeatureRequest;
import com.tobeto.pair6.rentACar.services.dtos.additionalFeature.requests.DeleteAdditionalFeatureRequest;
import com.tobeto.pair6.rentACar.services.dtos.additionalFeature.requests.UpdateAdditionalFeatureRequest;
import com.tobeto.pair6.rentACar.services.dtos.additionalFeature.responses.GetAllAdditionalFeaturesResponse;
import com.tobeto.pair6.rentACar.services.dtos.additionalFeature.responses.GetByIdAdditionalFeatureResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/additionalFeatures")
@AllArgsConstructor
@CrossOrigin
public class AdditionalFeaturesController {

    private final AdditionalFeatureService additionalFeatureService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddAdditionalFeatureRequest addAdditionalFeatureRequest) {

        return this.additionalFeatureService.add(addAdditionalFeatureRequest);

    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody @Valid DeleteAdditionalFeatureRequest deleteAdditionalFeatureRequest) {

        return this.additionalFeatureService.delete(deleteAdditionalFeatureRequest);

    }

    @PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateAdditionalFeatureRequest updateAdditionalFeatureRequest) {

        return this.additionalFeatureService.update(updateAdditionalFeatureRequest);

    }

    @GetMapping("/getAll")
    public DataResult<List<GetAllAdditionalFeaturesResponse>> getAll() {

        return this.additionalFeatureService.getAll();

    }

    @GetMapping("/getById/{id}")
    public DataResult<GetByIdAdditionalFeatureResponse> getById(@PathVariable Integer id) {

        return this.additionalFeatureService.getById(id);

    }

}
