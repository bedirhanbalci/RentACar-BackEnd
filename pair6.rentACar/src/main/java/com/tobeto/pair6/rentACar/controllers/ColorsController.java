package com.tobeto.pair6.rentACar.controllers;

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
public class ColorsController {

    private final ColorService colorService;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddColorRequest addColorRequest){
        colorService.add(addColorRequest);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteColorRequest deleteColorRequest){
        colorService.delete(deleteColorRequest);
    }
    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateColorRequest updateColorRequest){
        colorService.update(updateColorRequest);
    }
    @GetMapping("/getAll")
    public List<GetAllColorsResponse> getAll(){
        return colorService.getAll();
    }
    @GetMapping("/getById/{id}")
    public GetByIdColorResponse getById(@PathVariable int id){
        return colorService.getById(id);
    }

}
