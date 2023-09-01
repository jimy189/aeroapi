package com.br.aeroapi.dto;

import com.br.aeroapi.model.Bagagem;
import com.br.aeroapi.model.Classe;
import com.br.aeroapi.model.Passageiro;
import com.br.aeroapi.model.Voo;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.security.Timestamp;
import java.time.LocalDate;
import java.util.Date;

public class CompraPassagemDTO {
    private Long idVoo;
    private Long idPassagem;

    private String nome;
    private String cpf;

    private String dataNascimento;
    private Boolean flagBagagem;



    public Long getIdVoo() {
        return idVoo;
    }

    public void setIdVoo(Long idVoo) {
        this.idVoo = idVoo;
    }

    public Long getIdPassagem() {
        return idPassagem;
    }

    public void setIdPassagem(Long idPassagem) {
        this.idPassagem = idPassagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getFlagBagagem() {
        return flagBagagem;
    }

    public void setFlagBagagem(Boolean flagBagagem) {
        this.flagBagagem = flagBagagem;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
