package com.smartloan.auth.authentication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
