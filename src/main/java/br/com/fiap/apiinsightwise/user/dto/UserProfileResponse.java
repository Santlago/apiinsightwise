package br.com.fiap.apiinsightwise.user.dto;

import br.com.fiap.apiinsightwise.user.User;

public record UserProfileResponse(
        String name,
        String email,
        String cnpj,
        String avatar
) {
    public UserProfileResponse(User user){
        this(user.getName(), user.getEmail(), user.getCnpj(), user.getAvatar());
    }
}
