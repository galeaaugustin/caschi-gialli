package com.caschigialli.api.dtos;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record CustomerDto(
        @NotNull Long userId,
        @NotNull String firstName,
        @NotNull String lastName,
        @NotNull String userName,
        @NotNull String password,
        @NotNull String activeToken,
        @NotNull String customerType,
        @NotNull @Email String email,
        @NotNull String phoneNumber,
        @NotNull String isCompany,
        @NotNull String companyName,
        @NotNull String username
) { }
