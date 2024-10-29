package com.fiap.coletaai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tb_coleta")
public class ColetaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tipoColeta;

    private LocalDate dataColeta;

    private String nomeContato;

    private String telefoneContato;

    private String emailContato;

    private String enderecoContato;

    public ColetaEntity() {}

    public ColetaEntity(String tipoColeta, LocalDate dataColeta, String nomeContato, String telefoneContato, String emailContato, String enderecoContato) {
        this.tipoColeta = tipoColeta;
        this.dataColeta = dataColeta;
        this.nomeContato = nomeContato;
        this.telefoneContato = telefoneContato;
        this.emailContato = emailContato;
        this.enderecoContato = enderecoContato;
    }

    public Integer getId() {
        return id;
    }

    public String getTipoColeta() {
        return tipoColeta;
    }

    public void setTipoColeta(String tipoColeta) {
        this.tipoColeta = tipoColeta;
    }

    public LocalDate getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(LocalDate dataColeta) {
        this.dataColeta = dataColeta;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public String getEnderecoContato() {
        return enderecoContato;
    }

    public void setEnderecoContato(String enderecoContato) {
        this.enderecoContato = enderecoContato;
    }

    @Override
    public String toString() {
        return "Coleta{" +
                "id=" + id +
                ", tipoColeta='" + tipoColeta + '\'' +
                ", dataColeta=" + dataColeta +
                ", nomeContato='" + nomeContato + '\'' +
                ", telefoneContato='" + telefoneContato + '\'' +
                ", emailContato='" + emailContato + '\'' +
                ", enderecoContato='" + enderecoContato + '\'' +
                '}';
    }
}
