package com.br.aeroapi.repository;

import com.br.aeroapi.model.Passageiro;
import com.br.aeroapi.model.Voo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {
    @Query("select p from Passageiro p  where p.id = :idPassageiro")
    Passageiro findByIdPassageiro(Long idPassageiro);

    Passageiro findByCpf(String cpf);
}
