package com.fiap.coletaai.service;

import com.fiap.coletaai.model.ColetaEntity;
import com.fiap.coletaai.repository.ColetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColetaService {

    @Autowired
    private ColetaRepository repository;

    public void save(ColetaEntity entity) {
        repository.save(entity);
    }

    public Optional<ColetaEntity> getById(Integer id) {
        return repository.findById(id);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public List<ColetaEntity> getAll() {
        return repository.findAll();
    }

    public ColetaEntity update(Integer id, ColetaEntity entity) {
        Optional<ColetaEntity> oldColeta = repository.findById(id);
        if (oldColeta.isPresent()) {
            ColetaEntity coleta = oldColeta.get();
            coleta.setDataColeta(entity.getDataColeta());
            coleta.setTipoColeta(entity.getTipoColeta());
            coleta.setEmailContato(entity.getEmailContato());
            coleta.setEnderecoContato(entity.getEnderecoContato());
            coleta.setTelefoneContato(entity.getTelefoneContato());
            coleta.setNomeContato(entity.getNomeContato());

            repository.save(coleta);
            System.out.println("Objeto coleta: " + id + " foi atualizado com sucesso!");

            return coleta;
        }
        return null;
    }

}
