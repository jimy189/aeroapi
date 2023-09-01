package com.br.aeroapi.model;

import com.br.aeroapi.dto.VoucherDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "voucher")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voucher")
    private Long id;
    @Column(name = "numero_passagem")
    private String numeroPassagem;
    @Column(name = "numero_voo")
    private String numeroVoo;
    @Column(name = "origem")
    private String origem;
    @Column(name = "destino")
    private String destino;
    @Column(name = "passageiro")
    private Long passageiro;
    @Column(name = "despacho_bagagem")
    private boolean despachoBagagem;

    public Voucher() {
        super();
    }
    public Voucher(VoucherDTO dto) {
        this.numeroPassagem = dto.getNumeroPassagem();
        this.numeroVoo = dto.getNumeroVoo();
        this.origem = dto.getOrigem();
        this.destino = dto.getDestino();
        this.passageiro = dto.getPassageiro();
        this.despachoBagagem = dto.isDespachoBagagem();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroPassagem() {
        return numeroPassagem;
    }

    public void setNumeroPassagem(String numeroPassagem) {
        this.numeroPassagem = numeroPassagem;
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public void setNumeroVoo(String numeroVoo) {
        this.numeroVoo = numeroVoo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Long getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Long passageiro) {
        this.passageiro = passageiro;
    }

    public boolean isDespachoBagagem() {
        return despachoBagagem;
    }

    public void setDespachoBagagem(boolean despachoBagagem) {
        this.despachoBagagem = despachoBagagem;
    }
}
