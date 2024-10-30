package com.fiap.coletaai.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_usuario")
public class UsuarioEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String senha;
    private String email;

    public UsuarioEntity() {}

    public UsuarioEntity(Integer id, String username, String password, String email) {
        this.id = id;
        this.nome = username;
        this.senha = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String username) {
        this.nome = username;
    }

    public void setSenha(String password) {
        this.senha = password;
    }

    public String getPassword() {
        return this.senha;
    }

    public String getUsername() {
        return this.nome;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

}