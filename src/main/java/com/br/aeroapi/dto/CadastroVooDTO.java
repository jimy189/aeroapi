package com.br.aeroapi.dto;

import java.util.List;

public class CadastroVooDTO {

    private String numero;

    private String dataHoraPartida;

    private long origemAeroporto;

    private long destinoAeroporto;

    private Boolean flagVooCancelado;

    private List<ClasseDTO> classes;

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

    public List<ClasseDTO> getClasses() {
        return classes;
    }

    public void setClasses(List<ClasseDTO> classes) {
        this.classes = classes;
    }
}
