package com.caschigialli.api.dtos;

import jakarta.validation.constraints.NotNull;

public record LoginDto(@NotNull String username, @NotNull String password) {

    @Override
    public String toString() {
        return "LoginDto{" +
                "username='" + username + '\'' +
                ", password='*********'" +
                '}';
    }
}
