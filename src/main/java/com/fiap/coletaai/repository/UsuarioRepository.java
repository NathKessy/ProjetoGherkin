package com.fiap.coletaai.repository;

import com.fiap.coletaai.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    UserDetails findByEmail(String username);
}
