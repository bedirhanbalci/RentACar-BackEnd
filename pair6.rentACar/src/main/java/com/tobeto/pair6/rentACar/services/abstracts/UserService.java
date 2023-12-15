package com.tobeto.pair6.rentACar.services.abstracts;

import com.tobeto.pair6.rentACar.services.dtos.user.requests.AddUserRequest;
import com.tobeto.pair6.rentACar.services.dtos.user.requests.DeleteUserRequest;
import com.tobeto.pair6.rentACar.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.pair6.rentACar.services.dtos.user.responses.GetAllUsersResponse;
import com.tobeto.pair6.rentACar.services.dtos.user.responses.GetByIdUserResponse;

import java.util.List;

public interface UserService {

    void add(AddUserRequest addUserRequest);

    void delete(DeleteUserRequest deleteUserRequest);

    void update(UpdateUserRequest updateUserRequest);

    List<GetAllUsersResponse> getAll();

    GetByIdUserResponse getById(int id);

    boolean getUserById(int id);
}
