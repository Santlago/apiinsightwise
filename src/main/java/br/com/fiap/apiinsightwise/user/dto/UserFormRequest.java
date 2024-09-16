package br.com.fiap.apiinsightwise.user.dto;

import br.com.fiap.apiinsightwise.user.User;

import java.time.LocalDateTime;

public record UserFormRequest(
        String name,
        String email,
        String password,
        String cnpj
) {
    public User toModel() {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .cnpj(cnpj)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
