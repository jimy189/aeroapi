package com.br.aeroapi.model;

import com.br.aeroapi.dto.EtiquetaBagagemDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "etiqueta_bagagem")
public class EtiquetaBagagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etiqueta_bagagem")
    private Long id;

    @Column(name = "numero_voo")
    private String numeroVoo;
    @Column(name = "numero_passagem")
    private String numeroPassagem;
    @Column(name = "numero_bagagem")
    private String numeroBagagem;
    @Column(name = "numero_passageiro")
    private String nomePassageiro;

    public EtiquetaBagagem() {
        super();
    }
    public EtiquetaBagagem(EtiquetaBagagemDTO dto) {
        this.numeroVoo= dto.getNumeroVoo();
        this.numeroPassagem = dto.getNumeroPassagem();
        this.numeroBagagem = dto.getNumeroBagagem();
        this.nomePassageiro = dto.getNomePassageiro();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
