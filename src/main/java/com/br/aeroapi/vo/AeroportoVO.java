package com.br.aeroapi.vo;

import com.br.aeroapi.model.Aeroporto;

public class AeroportoVO {
    private String nome;
    private String codigoIATA;

    public AeroportoVO() {
        super();
    }

    public AeroportoVO(Aeroporto aeroporto) {
        this.nome = aeroporto.getNome();
        this.codigoIATA = aeroporto.getCodigoIata();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoIATA() {
        return codigoIATA;
    }

    public void setCodigoIATA(String codigoIATA) {
        this.codigoIATA = codigoIATA;
    }
}
