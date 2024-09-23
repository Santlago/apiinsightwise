package br.com.fiap.apiinsightwise.process.dto;

import java.time.LocalDateTime;
import java.util.Optional;

import br.com.fiap.apiinsightwise.process.Process;
import br.com.fiap.apiinsightwise.user.User;

public record ProcessFormRequest(
        String name,
        String process
) {
    public Process toModel(User user) {
        return Process.builder()
                .name(name)
                .process(process)
                .createdAt(LocalDateTime.now())
                .user(user)
                .build();
    }
}
