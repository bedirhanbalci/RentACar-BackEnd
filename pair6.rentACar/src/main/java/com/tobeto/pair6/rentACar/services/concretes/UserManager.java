package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.core.utilities.results.*;
import com.tobeto.pair6.rentACar.entities.concretes.User;
import com.tobeto.pair6.rentACar.repositories.UserRepository;
import com.tobeto.pair6.rentACar.services.abstracts.CorporateCustomerService;
import com.tobeto.pair6.rentACar.services.abstracts.IndividualCustomerService;
import com.tobeto.pair6.rentACar.services.abstracts.UserService;
import com.tobeto.pair6.rentACar.services.constants.Messages;
import com.tobeto.pair6.rentACar.services.dtos.corporateCustomer.requests.UpdateCorporateCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.individualCustomer.requests.UpdateIndividualCustomerRequest;
import com.tobeto.pair6.rentACar.services.dtos.user.requests.AddUserRequest;
import com.tobeto.pair6.rentACar.services.dtos.user.requests.DeleteUserRequest;
import com.tobeto.pair6.rentACar.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.pair6.rentACar.services.dtos.user.responses.GetAllUsersResponse;
import com.tobeto.pair6.rentACar.services.dtos.user.responses.GetByIdUserResponse;
import com.tobeto.pair6.rentACar.services.rules.UserBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;

    private final ModelMapperService modelMapperService;

    private final UserBusinessRules userBusinessRules;

    private final CorporateCustomerService corporateCustomerService;

    private final IndividualCustomerService individualCustomerService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Result add(AddUserRequest addUserRequest) {

        this.userBusinessRules.checkIfUserByEmailExists(addUserRequest.getEmail());

        User user = this.modelMapperService.forRequest()
                .map(addUserRequest, User.class);
        user.setId(null);

        this.userRepository.save(user);

        return new SuccessResult(Messages.ADD);

    }

    @Override
    public Result delete(DeleteUserRequest deleteUserRequest) {

        this.userBusinessRules.checkIfUserByIdExists(deleteUserRequest.getId());

        User user = this.modelMapperService.forRequest()
                .map(deleteUserRequest, User.class);

        this.userRepository.delete(user);

        return new SuccessResult(Messages.DELETE);

    }

    @Override
    public Result update(UpdateUserRequest updateUserRequest) {

        Optional<User> optionalUser = userRepository.findById(updateUserRequest.getId());

        if (optionalUser.isEmpty()) {
            return new ErrorResult(Messages.USER_NOT_FOUND);
        }

        User user = optionalUser.get();

        String newPassword = updateUserRequest.getPassword();
        if (newPassword != null && !newPassword.isBlank()) {
            user.setPassword(passwordEncoder.encode(newPassword));
        }

        user.setAddress(updateUserRequest.getAddress());
        user.setImagePath(updateUserRequest.getImagePath());
        user.setPhoneNumber(updateUserRequest.getPhoneNumber());

        this.userRepository.save(user);

        if (!updateUserRequest.getCompanyName().isBlank()) {
            this.corporateCustomerService.update(
                    UpdateCorporateCustomerRequest.builder()
                            .id(user.getCorporateCustomers().get(0).getId())
                            .userId(user.getId())
                            .companyName(updateUserRequest.getCompanyName())
                            .contactName(updateUserRequest.getContactName())
                            .contactTitle(updateUserRequest.getContactTitle())
                            .taxNumber(updateUserRequest.getTaxNumber())
                            .build()
            );
        } else {

            this.individualCustomerService.update(
                    UpdateIndividualCustomerRequest.builder()
                            .id(user.getIndividualCustomers().get(0).getId())
                            .firstName(updateUserRequest.getFirstName())
                            .lastName(updateUserRequest.getLastName())
                            .nationalityNo(updateUserRequest.getNationalityNo())
                            .birthDate(updateUserRequest.getBirthDate())
                            .userId(user.getId())
                            .build()
            );
        }

        return new SuccessResult(Messages.UPDATE);
    }

    @Override
    public DataResult<List<GetAllUsersResponse>> getAll() {

        List<User> users = userRepository.findAll();

        List<GetAllUsersResponse> usersResponse = users.stream()
                .map(user -> this.modelMapperService.forResponse().map(user, GetAllUsersResponse.class)).toList();

        return new SuccessDataResult<>(usersResponse, Messages.GET_ALL);

    }

    @Override
    public List<Object> getById(Integer id) {

        this.userBusinessRules.checkIfUserByIdExists(id);

        List<Object> result = new ArrayList<>();


        User user = userRepository.findById(id).orElseThrow();

        GetByIdUserResponse response = this.modelMapperService.forResponse()
                .map(user, GetByIdUserResponse.class);

        if (user.getCorporateCustomers().size() > 0){
           result.add(this.corporateCustomerService.getById(user.getCorporateCustomers().get(0).getId()).getData());
        }else{
            result.add(this.individualCustomerService.getById(user.getIndividualCustomers().get(0).getId()).getData());
        }

        result.add(response);

        return result;

    }

    @Override
    public boolean getUserById(Integer id) {

        return this.userRepository.existsById(id);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(Messages.USER_NOT_FOUND));
    }
}
