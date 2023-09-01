package com.br.aeroapi.repository;

import com.br.aeroapi.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {
Compra findByIdVooAndIdPassagemAndCpf(Long idVoo, Long idPassagem, String cpf);
}
