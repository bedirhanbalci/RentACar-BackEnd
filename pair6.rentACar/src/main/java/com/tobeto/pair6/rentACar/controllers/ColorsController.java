package com.tobeto.pair6.rentACar.controllers;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.abstracts.ColorService;
import com.tobeto.pair6.rentACar.services.dtos.color.requests.AddColorRequest;
import com.tobeto.pair6.rentACar.services.dtos.color.requests.DeleteColorRequest;
import com.tobeto.pair6.rentACar.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.pair6.rentACar.services.dtos.color.responses.GetAllColorsResponse;
import com.tobeto.pair6.rentACar.services.dtos.color.responses.GetByIdColorResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colors")
@AllArgsConstructor
@CrossOrigin
public class ColorsController {

    private final ColorService colorService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddColorRequest addColorRequest) {

        return this.colorService.add(addColorRequest);

    }

    @DeleteMapping()
    public Result delete(@RequestBody @Valid DeleteColorRequest deleteColorRequest) {

        return this.colorService.delete(deleteColorRequest);

    }

    @PutMapping()
    public Result update(@RequestBody @Valid UpdateColorRequest updateColorRequest) {

        return this.colorService.update(updateColorRequest);

    }

    @GetMapping()
    public DataResult<List<GetAllColorsResponse>> getAll() {

        return this.colorService.getAll();

    }

    @GetMapping("/{id}")
    public DataResult<GetByIdColorResponse> getById(@PathVariable Integer id) {

        return this.colorService.getById(id);

    }

}
