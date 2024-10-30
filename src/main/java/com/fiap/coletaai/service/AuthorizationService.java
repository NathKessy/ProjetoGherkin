package com.fiap.coletaai.service;

import com.fiap.coletaai.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    @Autowired
    UsuarioRepository repository;

}
