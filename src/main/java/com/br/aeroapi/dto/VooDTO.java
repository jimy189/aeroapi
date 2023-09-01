package com.br.aeroapi.dto;

import com.br.aeroapi.model.Passagem;

import java.util.List;

public class VooDTO {

    private String numero;

    private String dataHoraPartida;

    private long origemAeroporto;

    private long destinoAeroporto;

    private Boolean flagVooCancelado;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDataHoraPartida() {
        return dataHoraPartida;
    }

    public void setDataHoraPartida(String dataHoraPartida) {
        this.dataHoraPartida = dataHoraPartida;
    }

    public long getOrigemAeroporto() {
        return origemAeroporto;
    }

    public void setOrigemAeroporto(long origemAeroporto) {
        this.origemAeroporto = origemAeroporto;
    }

    public long getDestinoAeroporto() {
        return destinoAeroporto;
    }

    public void setDestinoAeroporto(long destinoAeroporto) {
        this.destinoAeroporto = destinoAeroporto;
    }
    public Boolean getFlagVooCancelado() {
        return flagVooCancelado;
    }

    public void setFlagVooCancelado(Boolean flagVooCancelado) {
        this.flagVooCancelado = flagVooCancelado;
    }
}
