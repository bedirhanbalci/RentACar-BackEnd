package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.entities.User;
import com.tobeto.pair6.rentACar.repositories.UserRepository;
import com.tobeto.pair6.rentACar.services.abstracts.UserService;
import com.tobeto.pair6.rentACar.services.dtos.user.requests.AddUserRequest;
import com.tobeto.pair6.rentACar.services.dtos.user.requests.DeleteUserRequest;
import com.tobeto.pair6.rentACar.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.pair6.rentACar.services.dtos.user.responses.GetAllUsersResponse;
import com.tobeto.pair6.rentACar.services.dtos.user.responses.GetByIdUserResponse;
import com.tobeto.pair6.rentACar.services.rules.UserBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;
    private final UserBusinessRules userBusinessRules;

    @Override
    public void add(AddUserRequest addUserRequest) {

        this.userBusinessRules.checkIfUserByEmailExists(addUserRequest.getEmail());

        User user = this.modelMapperService.forRequest().map(addUserRequest, User.class);

        this.userRepository.save(user);

    }

    @Override
    public void delete(DeleteUserRequest deleteUserRequest) {

        this.userBusinessRules.checkIfUserByIdExists(deleteUserRequest.getId());

        User user = this.modelMapperService.forRequest().map(deleteUserRequest, User.class);

        this.userRepository.delete(user);

    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {

        this.userBusinessRules.checkIfUserByIdExists(updateUserRequest.getId());

        this.userBusinessRules.checkIfUserByEmailExists(updateUserRequest.getEmail());

        User user = this.modelMapperService.forRequest().map(updateUserRequest, User.class);

        this.userRepository.save(user);
    }

    @Override
    public List<GetAllUsersResponse> getAll() {

        List<User> users = userRepository.findAll();

        List<GetAllUsersResponse> usersResponse = users.stream()
                .map(user -> this.modelMapperService.forResponse().map(user, GetAllUsersResponse.class)).toList();
        return usersResponse;
    }

    @Override
    public GetByIdUserResponse getById(int id) {

        this.userBusinessRules.checkIfUserByIdExists(id);

        GetByIdUserResponse response = this.modelMapperService.forResponse().map(userRepository.findById(id), GetByIdUserResponse.class);
        return response;
    }

    @Override
    public boolean getUserById(int id) {
        return this.userRepository.existsById(id);
    }
}
