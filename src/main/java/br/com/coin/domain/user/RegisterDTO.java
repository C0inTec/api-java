package br.com.coin.domain.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RegisterDTO(
        @NotBlank String email,
        @NotBlank String password,
        @NotBlank @Pattern(regexp = "admin|user", message = "Role must be 'admin' or 'user'") String role
) {}
