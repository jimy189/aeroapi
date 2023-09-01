package com.br.aeroapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bagagem")
public class Bagagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bagagem")
    private Long id;
    @Column(name = "numero_unico")
    private String numeroUnico;
    @Column(name = "passagem")
    private Long passagem;

    public Bagagem(String numeroUnico, Long passagem) {
        this.numeroUnico = numeroUnico;
        this.passagem = passagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroUnico() {
        return numeroUnico;
    }

    public void setNumeroUnico(String numeroUnico) {
        this.numeroUnico = numeroUnico;
    }

    public Long getPassagem() {
        return passagem;
    }

    public void setPassagem(Long passagem) {
        this.passagem = passagem;
    }
}
