package com.br.aeroapi.dto;

public class VooPassagemDTO {

    private Long origemAeroporto;
    private Long destinoAeroporto;
    private String dataHoraPartida;
    private double precoPassagem;

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

    public String getDataHoraPartida() {
        return dataHoraPartida;
    }

    public void setDataHoraPartida(String dataHoraPartida) {
        this.dataHoraPartida = dataHoraPartida;
    }

    public double getPrecoPassagem() {
        return precoPassagem;
    }

    public void setPrecoPassagem(double precoPassagem) {
        this.precoPassagem = precoPassagem;
    }
}
