package com.tobeto.pair6.rentACar.controllers;

import com.tobeto.pair6.rentACar.services.abstracts.UserService;
import com.tobeto.pair6.rentACar.services.dtos.user.requests.AddUserRequest;
import com.tobeto.pair6.rentACar.services.dtos.user.requests.DeleteUserRequest;
import com.tobeto.pair6.rentACar.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.pair6.rentACar.services.dtos.user.responses.GetAllUsersResponse;
import com.tobeto.pair6.rentACar.services.dtos.user.responses.GetByIdUserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {

    private final UserService userService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddUserRequest addUserRequest){
        userService.add(addUserRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteUserRequest deleteUserRequest){
        userService.delete(deleteUserRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateUserRequest updateUserRequest){
        userService.update(updateUserRequest);
    }

    @GetMapping("/getAll")
    public List<GetAllUsersResponse> getAll(){
        return userService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetByIdUserResponse getById(@PathVariable int id){
        return userService.getById(id);
    }
}
