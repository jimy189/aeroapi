package com.br.aeroapi.repository;

import com.br.aeroapi.model.Voo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VooRepository extends JpaRepository<Voo, Long> {
}
