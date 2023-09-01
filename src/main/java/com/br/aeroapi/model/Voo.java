package com.br.aeroapi.model;

import com.br.aeroapi.dto.VooDTO;
import com.br.aeroapi.util.Util;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "voo")
public class Voo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voo")
    private Long id;
    @Column(name = "numero")
    private String numero;
    @Column(name = "data_hora_partida")
    private Timestamp dataHoraPartida;
    @Column(name = "origem_aeroporto")
    private Long origemAeroporto;
    @Column(name = "destino_aeroporto")
    private Long destinoAeroporto;
    @Column(name = "flag_voo_cancelado")
    private Boolean flagVooCancelado;

    public Voo() {
    }

    public Voo(VooDTO dto) {
        this.numero = dto.getNumero();
        this.dataHoraPartida = Util.formatarData(dto.getDataHoraPartida());
        this.origemAeroporto = dto.getOrigemAeroporto();
        this.destinoAeroporto = dto.getDestinoAeroporto();
        this.flagVooCancelado = dto.getFlagVooCancelado();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public java.sql.Timestamp getDataHoraPartida() {
        return dataHoraPartida;
    }

    public void setDataHoraPartida(java.sql.Timestamp dataHoraPartida) {
        this.dataHoraPartida = dataHoraPartida;
    }

    public Long getOrigemAeroporto() {
        return origemAeroporto;
    }

    public void setOrigemAeroporto(Long origemAeroporto) {
        this.origemAeroporto = origemAeroporto;
    }

    public Long getDestinoAeroporto() {
        return destinoAeroporto;
    }

    public void setDestinoAeroporto(Long destinoAeroporto) {
        this.destinoAeroporto = destinoAeroporto;
    }

    public Boolean getFlagVooCancelado() {
        return flagVooCancelado;
    }

    public void setFlagVooCancelado(Boolean flagVooCancelado) {
        this.flagVooCancelado = flagVooCancelado;
    }
}
