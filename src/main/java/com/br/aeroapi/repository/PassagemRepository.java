package com.br.aeroapi.repository;

import com.br.aeroapi.model.Passagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.sql.Timestamp;
import java.util.List;

public interface PassagemRepository extends JpaRepository<Passagem, Long> {
    List<Passagem> findByVoo(Long idVoo);

    Passagem findByIdAndVoo(Long idPassagem, Long idVoo);

    Passagem findByIdAndVooAndPassageiro(Long idPassagem, Long idVoo, Long idPassageiro);

    List<Passagem> findByPassageiro(Long idPassageiro);

    @Query(value = "SELECT p FROM Passagem p " +
            " INNER JOIN Voo v on v.id = p.passageiro " +
            "WHERE v.origemAeroporto = :origem " +
            "AND v.destinoAeroporto = :destino " +
            "AND v.dataHoraPartida = :data " +
            "AND (:precoPassagem IS NULL OR p.precoTotal = :precoPassagem)")
    List<Passagem> findPassageiroComData(Long origem, Long destino, Timestamp data, Double precoPassagem);




}
