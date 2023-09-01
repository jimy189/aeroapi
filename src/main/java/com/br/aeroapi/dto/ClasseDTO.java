package com.br.aeroapi.dto;

import jakarta.persistence.Column;

public class ClasseDTO {

    private Long idVoo;

    private String tipo;

    private int capacidadeMaxima;

    private double valorAssento;

    public Long getIdVoo() {
        return idVoo;
    }

    public void setIdVoo(Long idVoo) {
        this.idVoo = idVoo;
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
}
