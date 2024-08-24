package br.com.fiap.apiheatwise.user.dto;

import br.com.fiap.apiheatwise.user.User;

import java.time.LocalDateTime;

public record UserFormRequest(
        String name,
        String email,
        String password,
        String cnpj,
        int planId
) {
    public User toModel() {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .cnpj(cnpj)
                .planId(planId)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
