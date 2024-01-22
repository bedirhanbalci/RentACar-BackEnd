package com.tobeto.pair6.rentACar.controllers;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.abstracts.BranchService;
import com.tobeto.pair6.rentACar.services.dtos.branch.requests.AddBranchRequest;
import com.tobeto.pair6.rentACar.services.dtos.branch.requests.DeleteBranchRequest;
import com.tobeto.pair6.rentACar.services.dtos.branch.requests.UpdateBranchRequest;
import com.tobeto.pair6.rentACar.services.dtos.branch.responses.GetAllBranchesResponse;
import com.tobeto.pair6.rentACar.services.dtos.branch.responses.GetByIdBranchResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
@AllArgsConstructor
@CrossOrigin
public class BranchesController {

    private final BranchService branchService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddBranchRequest addBranchRequest) {

        return this.branchService.add(addBranchRequest);

    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody @Valid DeleteBranchRequest deleteBranchRequest) {

        return this.branchService.delete(deleteBranchRequest);

    }

    @PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateBranchRequest updateBranchRequest) {

        return this.branchService.update(updateBranchRequest);

    }

    @GetMapping("/getAll")
    public DataResult<List<GetAllBranchesResponse>> getAll() {

        return this.branchService.getAll();

    }

    @GetMapping("/getById/{id}")
    public DataResult<GetByIdBranchResponse> getById(@PathVariable Integer id) {

        return this.branchService.getById(id);

    }

}
