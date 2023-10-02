package com.alura.api.model.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserRegistrationData(
        @NotNull
        String name,
        @NotNull
                @Email
        String email,
        @NotNull
        String password
) {
}
