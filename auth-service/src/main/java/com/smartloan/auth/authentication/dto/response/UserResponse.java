package com.smartloan.auth.authentication.dto.response;

import com.smartloan.auth.authentication.enums.Role;
import com.smartloan.auth.authentication.enums.UserStatus;

public record UserResponse(Long id, String email, Role role, UserStatus userStatus) {
}
