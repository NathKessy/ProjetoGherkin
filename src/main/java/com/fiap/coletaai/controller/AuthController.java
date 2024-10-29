package com.fiap.coletaai.controller;

import com.fiap.coletaai.dto.LoginDto;
import com.fiap.coletaai.dto.TokenDTO;
import com.fiap.coletaai.dto.UsuarioCadastroDTO;
import com.fiap.coletaai.dto.UsuarioExibicaoDTO;
import com.fiap.coletaai.model.UsuarioEntity;
import com.fiap.coletaai.security.TokenService;
import com.fiap.coletaai.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService service;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDto dto) {
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());

        Authentication auth = authenticationManager.authenticate(usernamePassword);

        String token = this.tokenService.getToken((UsuarioEntity) auth.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(token));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDTO register(@RequestBody @Valid UsuarioCadastroDTO dto) {
        UsuarioExibicaoDTO usuarioSalvo = null;
        usuarioSalvo = service.salvarUsuario(dto);
        return usuarioSalvo;
    }

}
