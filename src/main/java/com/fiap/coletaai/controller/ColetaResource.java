package com.fiap.coletaai.controller;

import com.fiap.coletaai.model.ColetaEntity;
import com.fiap.coletaai.service.ColetaService;
import com.fiap.coletaai.util.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coleta")
public class ColetaResource {

    @Autowired
    private ColetaService coletaService;

    @GetMapping("/{id}")
    public ResponseEntity<ColetaEntity> buscarPorId(@PathVariable("id") Integer id) {
        final Optional<ColetaEntity> coleta = this.coletaService.getById(id);
        return coleta.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<ColetaEntity>> listar() {
        List<ColetaEntity> coleta = this.coletaService.getAll();
        return ResponseEntity.ok().body(coleta);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ColetaEntity> inserir(@RequestBody ColetaEntity coleta) {
        this.coletaService.save(coleta);
        return new ResponseEntity<>(coleta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColetaEntity> atualizar(@PathVariable("id") Integer id, @RequestBody ColetaEntity coletaEntity) {
        final Optional<ColetaEntity> coleta = this.coletaService.getById(id);
        if(coleta.isPresent()) {
            ColetaEntity newColeta = this.coletaService.update(id, coletaEntity);
            return new ResponseEntity<>(newColeta, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Mensagem> remover(@PathVariable("id") Integer id) {
        Optional<ColetaEntity> coleta = this.coletaService.getById(id);
        if (coleta.isPresent()) {
            coletaService.deleteById(id);
            return new ResponseEntity<>(new Mensagem("Objeto id foi deletado com sucesso", id), HttpStatus.OK);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
