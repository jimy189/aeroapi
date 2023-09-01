package com.br.aeroapi.dto;

import com.br.aeroapi.model.Bagagem;
import com.br.aeroapi.model.Classe;
import com.br.aeroapi.model.Passageiro;
import com.br.aeroapi.model.Voo;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class PassagemDTO {
    private Long id;
    private String numeroIdentificacao;
    private double precoTotal;
    private Long classe;
    private Long passageiro;
    private Long voo;

    private Boolean flagBagagem;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroIdentificacao() {
        return numeroIdentificacao;
    }

    public void setNumeroIdentificacao(String numeroIdentificacao) {
        this.numeroIdentificacao = numeroIdentificacao;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Long getClasse() {
        return classe;
    }

    public void setClasse(Long classe) {
        this.classe = classe;
    }

    public Long getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Long passageiro) {
        this.passageiro = passageiro;
    }

    public Long getVoo() {
        return voo;
    }

    public void setVoo(Long voo) {
        this.voo = voo;
    }

    public Boolean getFlagBagagem() {
        return flagBagagem;
    }

    public void setFlagBagagem(Boolean flagBagagem) {
        this.flagBagagem = flagBagagem;
    }
}
