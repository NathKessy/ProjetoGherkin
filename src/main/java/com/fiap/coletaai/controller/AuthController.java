package com.fiap.coletaai.controller;

import com.fiap.coletaai.dto.UsuarioCadastroDTO;
import com.fiap.coletaai.dto.UsuarioExibicaoDTO;
import com.fiap.coletaai.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDTO register(@RequestBody @Valid UsuarioCadastroDTO dto) {
        UsuarioExibicaoDTO usuarioSalvo = null;
        usuarioSalvo = service.salvarUsuario(dto);
        return usuarioSalvo;
    }

}
