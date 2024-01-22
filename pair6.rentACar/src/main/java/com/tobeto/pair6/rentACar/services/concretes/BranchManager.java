package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessDataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.pair6.rentACar.entities.concretes.Branch;
import com.tobeto.pair6.rentACar.repositories.BranchRepository;
import com.tobeto.pair6.rentACar.services.abstracts.BranchService;
import com.tobeto.pair6.rentACar.services.dtos.branch.requests.AddBranchRequest;
import com.tobeto.pair6.rentACar.services.dtos.branch.requests.DeleteBranchRequest;
import com.tobeto.pair6.rentACar.services.dtos.branch.requests.UpdateBranchRequest;
import com.tobeto.pair6.rentACar.services.dtos.branch.responses.GetAllBranchesResponse;
import com.tobeto.pair6.rentACar.services.dtos.branch.responses.GetByIdBranchResponse;
import com.tobeto.pair6.rentACar.services.rules.BranchBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BranchManager implements BranchService {

    private final BranchRepository branchRepository;

    private final ModelMapperService modelMapperService;

    private final BranchBusinessRules branchBusinessRules;

    @Override
    public Result add(AddBranchRequest addBranchRequest) {

        Branch branch = this.modelMapperService.forRequest()
                .map(addBranchRequest, Branch.class);
        branch.setId(null);

        this.branchRepository.save(branch);

        return new SuccessResult("Şube eklendi!");

    }

    @Override
    public Result delete(DeleteBranchRequest deleteBranchRequest) {

        this.branchBusinessRules.checkIfBranchByIdExists(deleteBranchRequest.getId());

        Branch branch = this.modelMapperService.forRequest()
                .map(deleteBranchRequest, Branch.class);

        this.branchRepository.delete(branch);

        return new SuccessResult("Şube silindi!");

    }

    @Override
    public Result update(UpdateBranchRequest updateBranchRequest) {

        this.branchBusinessRules.checkIfBranchByIdExists(updateBranchRequest.getId());

        Branch branch = this.modelMapperService.forRequest()
                .map(updateBranchRequest, Branch.class);

        this.branchRepository.save(branch);

        return new SuccessResult("Şube güncellendi!");

    }

    @Override
    public DataResult<List<GetAllBranchesResponse>> getAll() {

        List<Branch> branches = this.branchRepository.findAll();

        List<GetAllBranchesResponse> branchesResponse = branches.stream()
                .map(branch -> this.modelMapperService.forResponse().map(branch, GetAllBranchesResponse.class)).toList();

        return new SuccessDataResult<>(branchesResponse, "Tüm şubeler listelendi!");

    }

    @Override
    public DataResult<GetByIdBranchResponse> getById(Integer id) {

        this.branchBusinessRules.checkIfBranchByIdExists(id);

        GetByIdBranchResponse response = this.modelMapperService.forResponse()
                .map(branchRepository.findById(id), GetByIdBranchResponse.class);

        return new SuccessDataResult<>(response, "Şube listelendi!");

    }

}
