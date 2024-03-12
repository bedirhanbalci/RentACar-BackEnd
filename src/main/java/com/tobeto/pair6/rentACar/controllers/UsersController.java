package com.tobeto.pair6.rentACar.controllers;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.abstracts.UserService;
import com.tobeto.pair6.rentACar.services.dtos.user.requests.AddUserRequest;
import com.tobeto.pair6.rentACar.services.dtos.user.requests.DeleteUserRequest;
import com.tobeto.pair6.rentACar.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.pair6.rentACar.services.dtos.user.responses.GetAllUsersResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@CrossOrigin
public class UsersController {

    private final UserService userService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddUserRequest addUserRequest) {

        return this.userService.add(addUserRequest);

    }

    @DeleteMapping()
    public Result delete(@RequestBody @Valid DeleteUserRequest deleteUserRequest) {

        return this.userService.delete(deleteUserRequest);

    }

    @PutMapping()
    public Result update(@RequestBody @Valid UpdateUserRequest updateUserRequest) {

        return this.userService.update(updateUserRequest);

    }

    @GetMapping()
    public DataResult<List<GetAllUsersResponse>> getAll() {

        return this.userService.getAll();

    }

    @GetMapping("/{id}")
    public List<Object> getById(@PathVariable Integer id) {

        return this.userService.getById(id);

    }

}
