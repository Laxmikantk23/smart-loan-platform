package com.smartloan.auth.authentication.service.impl;

import com.smartloan.auth.authentication.dto.request.CreateUserRequest;
import com.smartloan.auth.authentication.dto.response.UserResponse;
import com.smartloan.auth.authentication.entity.User;
import com.smartloan.auth.authentication.enums.Role;
import com.smartloan.auth.authentication.enums.UserStatus;
import com.smartloan.auth.authentication.exception.UserNotFoundException;
import com.smartloan.auth.authentication.repository.UserRepository;
import com.smartloan.auth.authentication.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(CreateUserRequest request) {

        User user = User.builder()
                .emailId(request.email())
                .password(request.password())
                .role(Role.CUSTOMER)
                .userStatus(UserStatus.ACTIVE)
                .build();

        User savedUser = userRepository.save(user);

        return mapToUserResponse(savedUser);
    }

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public UserResponse getUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException(id));

        return mapToUserResponse(user);
    }

    private UserResponse mapToUserResponse(User user) {

        return new UserResponse(
                user.getId(),
                user.getEmailId(),
                user.getRole(),
                user.getUserStatus()
        );
    }
}