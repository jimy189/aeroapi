package com.br.aeroapi.model;

import com.br.aeroapi.dto.ClasseDTO;
import com.br.aeroapi.dto.VooDTO;
import com.br.aeroapi.util.Util;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "classe")
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classe")
    private Long id;
    @Column(name = "id_voo")
    private Long idVoo;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "capacidade_maxima")
    private int capacidadeMaxima;
    @Column(name = "valor_assento")
    private double valorAssento;

    public Classe(){
        super();
    }
    public Classe(Long idVoo,ClasseDTO dto) {
        this.idVoo = idVoo;
        this.tipo = dto.getTipo();
        this.capacidadeMaxima = dto.getCapacidadeMaxima();
        this.valorAssento = dto.getValorAssento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public double getValorAssento() {
        return valorAssento;
    }

    public void setValorAssento(double valorAssento) {
        this.valorAssento = valorAssento;
    }

    public Long getIdVoo() {
        return idVoo;
    }

    public void setIdVoo(Long idVoo) {
        this.idVoo = idVoo;
    }
}
