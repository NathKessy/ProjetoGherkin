package com.fiap.coletaai.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginDto(

        @NotBlank(message = "O e-mail do usuário é Obrigatório")
        @Email(message = "o e-mail do usuário não é válido!")
        String email,

        @NotBlank(message = "A Senha do usuário é obrigatório!")
        String senha
) {
}
