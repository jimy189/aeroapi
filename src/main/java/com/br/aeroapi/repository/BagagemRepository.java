package com.br.aeroapi.repository;

import com.br.aeroapi.model.Bagagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BagagemRepository extends JpaRepository<Bagagem, Long> {
}
