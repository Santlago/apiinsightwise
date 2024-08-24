package br.com.fiap.apiheatwise.user.dto;

import br.com.fiap.apiheatwise.user.User;

import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String name,
        String email,
        String cnpj,
        LocalDateTime createdAt
) {
    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCnpj(),
                user.getCreatedAt()
        );
    }
}
