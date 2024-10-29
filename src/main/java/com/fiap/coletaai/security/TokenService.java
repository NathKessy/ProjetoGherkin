package com.fiap.coletaai.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.fiap.coletaai.model.UsuarioEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${minha.chave.secreta}")
    private String palavraChaveSecreta;

    public String getToken(UsuarioEntity usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(palavraChaveSecreta);
            String token = JWT
                    .create()
                    .withIssuer("contatos")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(getExpiration())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException erro) {
            throw  new RuntimeException("Não foi possível gerar o token!");
        }
    }

    public String validarToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(palavraChaveSecreta);
            return JWT.require(algorithm)
                    .withIssuer("contatos")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException erro) {
            return "";
        }
    }

    public Instant getExpiration() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
