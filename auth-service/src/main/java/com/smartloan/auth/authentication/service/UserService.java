package com.smartloan.auth.authentication.service;

import com.smartloan.auth.authentication.dto.request.CreateUserRequest;
import com.smartloan.auth.authentication.dto.response.UserResponse;

public interface UserService {

    UserResponse createUser(CreateUserRequest request);

    UserResponse getUser(Long id);
}
