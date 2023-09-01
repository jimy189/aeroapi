package com.br.aeroapi.vo;

import com.br.aeroapi.model.Aeroporto;
import com.br.aeroapi.model.Passageiro;
import com.br.aeroapi.model.Passagem;
import com.br.aeroapi.model.Voo;

import java.time.LocalDateTime;
import java.util.List;

public class VooPassageiroVO {

    private Long idVoo;

    private List<String> nomePassageiros;


    public Long getIdVoo() {
        return idVoo;
    }

    public void setIdVoo(Long idVoo) {
        this.idVoo = idVoo;
    }

    public List<String> getNomePassageiros() {
        return nomePassageiros;
    }

    public void setNomePassageiros(List<String> nomePassageiros) {
        this.nomePassageiros = nomePassageiros;
    }
}
