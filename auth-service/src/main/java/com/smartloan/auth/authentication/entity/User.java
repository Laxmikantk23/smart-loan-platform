package com.smartloan.auth.authentication.entity;

import com.smartloan.auth.authentication.enums.Role;
import com.smartloan.auth.authentication.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    @Column(name = "email_id", nullable = false, unique = true, length = 100)
    private String emailId;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status", nullable = false, length = 30)
    private UserStatus userStatus;

    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;
}