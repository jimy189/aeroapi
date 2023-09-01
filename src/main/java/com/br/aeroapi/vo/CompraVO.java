package com.br.aeroapi.vo;

import com.br.aeroapi.model.Aeroporto;
import com.br.aeroapi.model.Compra;
import jakarta.persistence.Column;

public class CompraVO {
    private Long id;
    @Column(name = "id_Voo")
    private Long idVoo;
    @Column(name = "id_passagem")
    private Long idPassagem;
    @Column(name = "cpf")
    private String cpf;

    public CompraVO() {
        super();
    }

    public CompraVO(Compra compra) {
        this.idVoo = compra.getIdVoo();
        this.idPassagem = compra.getIdPassagem();
        this.cpf = compra.getCpf();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
