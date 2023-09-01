package com.br.aeroapi.dto;

import com.br.aeroapi.model.Passageiro;

public class VoucherDTO {

    private String numeroPassagem;
    private String numeroVoo;
    private String origem;
    private String destino;
    private Long passageiro;
    private boolean despachoBagagem;



    public String getNumeroPassagem() {
        return numeroPassagem;
    }

    public void setNumeroPassagem(String numeroPassagem) {
        this.numeroPassagem = numeroPassagem;
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public void setNumeroVoo(String numeroVoo) {
        this.numeroVoo = numeroVoo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Long getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Long passageiro) {
        this.passageiro = passageiro;
    }

    public boolean isDespachoBagagem() {
        return despachoBagagem;
    }

    public void setDespachoBagagem(boolean despachoBagagem) {
        this.despachoBagagem = despachoBagagem;
    }
}
