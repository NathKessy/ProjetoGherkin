package com.fiap.coletaai.repository;

import com.fiap.coletaai.model.ColetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColetaRepository extends JpaRepository<ColetaEntity, Integer> {
}
