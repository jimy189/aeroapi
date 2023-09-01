package com.br.aeroapi.vo;

import com.br.aeroapi.model.Aeroporto;
import com.br.aeroapi.model.Passagem;
import com.br.aeroapi.model.Voo;

import java.sql.Timestamp;
import java.util.List;

public class VooVO {
    private String numero;
    private Timestamp dataHoraPartida;
    private Long origemAeroporto;
    private Long destinoAeroporto;
    private Boolean flagVooCancelado;
    public VooVO(Voo voo) {
        this.numero = voo.getNumero();
        this.dataHoraPartida = voo.getDataHoraPartida();
        this.origemAeroporto = voo.getOrigemAeroporto();
        this.destinoAeroporto = voo.getDestinoAeroporto();
        this.flagVooCancelado = voo.getFlagVooCancelado();
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
