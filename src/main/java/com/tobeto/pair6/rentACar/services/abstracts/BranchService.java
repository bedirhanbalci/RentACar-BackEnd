package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.dtos.branch.requests.AddBranchRequest;
import com.tobeto.pair6.rentACar.services.dtos.branch.requests.DeleteBranchRequest;
import com.tobeto.pair6.rentACar.services.dtos.branch.requests.UpdateBranchRequest;
import com.tobeto.pair6.rentACar.services.dtos.branch.responses.GetAllBranchesResponse;
import com.tobeto.pair6.rentACar.services.dtos.branch.responses.GetByIdBranchResponse;
import com.tobeto.pair6.rentACar.services.dtos.car.responses.GetByIdCarResponse;

import java.util.List;

public interface BranchService {

    Result add(AddBranchRequest addBranchRequest);

    Result delete(DeleteBranchRequest deleteBranchRequest);

    Result update(UpdateBranchRequest updateBranchRequest);

    DataResult<List<GetAllBranchesResponse>> getAll();

    List<GetAllBranchesResponse> getByCity(String city);

    DataResult<GetByIdBranchResponse> getById(Integer id);

    DataResult<GetByIdCarResponse> getCarById(Integer id);


}
