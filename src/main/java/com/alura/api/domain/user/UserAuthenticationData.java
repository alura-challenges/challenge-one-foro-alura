package com.alura.api.domain.user;

public record UserAuthenticationData(
        String name,
        String password
) {
}
