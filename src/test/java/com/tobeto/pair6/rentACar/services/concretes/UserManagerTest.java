package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.pair6.rentACar.entities.concretes.User;
import com.tobeto.pair6.rentACar.repositories.UserRepository;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import com.tobeto.pair6.rentACar.services.dtos.user.requests.AddUserRequest;
import com.tobeto.pair6.rentACar.services.dtos.user.requests.DeleteUserRequest;
import com.tobeto.pair6.rentACar.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.pair6.rentACar.services.rules.UserBusinessRules;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {

    private UserManager userManager;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapperService modelMapperService;

    @Mock
    private UserBusinessRules userBusinessRules;

//    @BeforeEach
//    void setUp() {
//
//        MockitoAnnotations.openMocks(this);
//        ModelMapper mockedModelMapper = Mockito.mock(ModelMapper.class);
//        Mockito.when(modelMapperService.forRequest()).thenReturn(mockedModelMapper);
//        Mockito.when(modelMapperService.forResponse()).thenReturn(mockedModelMapper);
//        userManager = new UserManager(userRepository, modelMapperService, userBusinessRules);
//
//    }

    @AfterEach
    void tearDown() {

    }

//    @Test
//    void emailAlreadyExistsShouldThrowException() {
//
//        AddUserRequest addUserRequest = new AddUserRequest();
//        addUserRequest.setEmail("bedirhan@mail.com");
//
//        Mockito.when(userRepository.existsByEmail("bedirhan@mail.com")).thenReturn((true));
//
//
//        assertThrows(RuntimeException.class, () -> {
//            userManager.add(addUserRequest);
//        });
//
//    }

//    @Test
//    void successfullyAdd() {
//
//        AddUserRequest addUserRequest = new AddUserRequest();
//        addUserRequest.setEmail("bedirhan@mail.com");
//        addUserRequest.setPassword("123456");
//        addUserRequest.setPhoneNumber("00000000");
//        addUserRequest.setAddress("Istanbul");
//        addUserRequest.setImagePath("profile.url");
//
//        Mockito.when(modelMapperService.forRequest().map(addUserRequest, User.class)).thenReturn(new User());
//
//        Result result = userManager.add(addUserRequest);
//
//        assertEquals(SuccessResult.class, result.getClass());
//        assertEquals(Messages.ADD, result.getMessage());
//
//    }

//    @Test
//    void successfullyDelete() {
//
//        DeleteUserRequest deleteUserRequest = new DeleteUserRequest();
//        deleteUserRequest.setId(3);
//
//        Mockito.when(modelMapperService.forRequest().map(deleteUserRequest, User.class)).thenReturn(new User());
//
//        Result result = userManager.delete(deleteUserRequest);
//
//        assertEquals(SuccessResult.class, result.getClass());
//        assertEquals(Messages.DELETE, result.getMessage());
//
//    }

//    @Test
//    void successfullyUpdate() {
//
//        UpdateUserRequest updateUserRequest = new UpdateUserRequest();
//        updateUserRequest.setId(3);
//        updateUserRequest.setEmail("bedirhan@mail.com");
//        updateUserRequest.setPassword("123456");
//        updateUserRequest.setPhoneNumber("00000000");
//        updateUserRequest.setAddress("Istanbul");
//        updateUserRequest.setImagePath("profile.url");
//
//        Mockito.when(modelMapperService.forRequest().map(updateUserRequest, User.class)).thenReturn(new User());
//
//        Result result = userManager.update(updateUserRequest);
//
//        assertEquals(SuccessResult.class, result.getClass());
//        assertEquals(Messages.UPDATE, result.getMessage());
//
//    }

//    @Test
//    void successfullyGetAll() {
//
//        List<User> users = new ArrayList<>();
//        Mockito.when(userRepository.findAll()).thenReturn(users);
//        userManager.getAll();
//        assert true;
//
//    }

//    @Test
//    void successfullyGetById() {
//
//        User user = new User();
//        Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(new User()));
//        userManager.getById(user.getId());
//        assert true;
//
//    }

}