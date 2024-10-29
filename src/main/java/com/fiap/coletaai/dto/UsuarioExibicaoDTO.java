package com.fiap.coletaai.dto;

import com.fiap.coletaai.model.UsuarioEntity;

public record UsuarioExibicaoDTO(
        Integer usuarioId,
        String nome,
        String email) {

    public UsuarioExibicaoDTO(UsuarioEntity usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail());
    }
}