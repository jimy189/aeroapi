package com.br.aeroapi.dto;

public class EtiquetaBagagemDTO {

    private String numeroVoo;

    private String numeroPassagem;
    private String numeroBagagem;
    private String nomePassageiro;

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public void setNumeroVoo(String numeroVoo) {
        this.numeroVoo = numeroVoo;
    }

    public String getNumeroPassagem() {
        return numeroPassagem;
    }

    public void setNumeroPassagem(String numeroPassagem) {
        this.numeroPassagem = numeroPassagem;
    }

    public String getNumeroBagagem() {
        return numeroBagagem;
    }

    public void setNumeroBagagem(String numeroBagagem) {
        this.numeroBagagem = numeroBagagem;
    }

    public String getNomePassageiro() {
        return nomePassageiro;
    }

    public void setNomePassageiro(String nomePassageiro) {
        this.nomePassageiro = nomePassageiro;
    }
}
