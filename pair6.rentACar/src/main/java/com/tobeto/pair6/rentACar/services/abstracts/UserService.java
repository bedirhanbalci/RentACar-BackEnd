package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.dtos.user.requests.AddUserRequest;
import com.tobeto.pair6.rentACar.services.dtos.user.requests.DeleteUserRequest;
import com.tobeto.pair6.rentACar.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.pair6.rentACar.services.dtos.user.responses.GetAllUsersResponse;
import com.tobeto.pair6.rentACar.services.dtos.user.responses.GetByIdUserResponse;

import java.util.List;

public interface UserService {

    Result add(AddUserRequest addUserRequest);

    Result delete(DeleteUserRequest deleteUserRequest);

    Result update(UpdateUserRequest updateUserRequest);

    DataResult<List<GetAllUsersResponse>> getAll();

    DataResult<GetByIdUserResponse> getById(int id);

    boolean getUserById(int id);

}
