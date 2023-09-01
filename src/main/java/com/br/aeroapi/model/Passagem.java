package com.br.aeroapi.model;

import com.br.aeroapi.dto.PassagemDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "passagem")
public class Passagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_passagem")
    private Long id;

    @Column(name = "numero_identificacao")
    private String numeroIdentificacao;

    @Column(name = "preco_total")
    private double precoTotal;
    @Column(name = "classe")
    private Long classe;
    @Column(name = "passageiro")
    private Long passageiro;
    @Column(name = "voo")
    private Long voo;

    @Column(name = "flag_bagagem")
    private Boolean flagBagagem;


    public Passagem() {
       super();
    }
    public Passagem(PassagemDTO dto) {
        this.numeroIdentificacao = dto.getNumeroIdentificacao();
        this.precoTotal = dto.getPrecoTotal();
        this.classe = dto.getClasse();
        this.passageiro = dto.getPassageiro();
        this.voo = dto.getVoo();
        this.flagBagagem = dto.getFlagBagagem();

    }

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
