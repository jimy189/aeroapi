package com.br.aeroapi.service;

import com.br.aeroapi.dto.VooDTO;
import com.br.aeroapi.mapper.VooMapper;
import com.br.aeroapi.model.Voo;
import com.br.aeroapi.repository.VooRepository;
import com.br.aeroapi.vo.VooVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassageiroService {
    @Autowired
    private VooRepository vooRepository;

    public List<VooVO> listarTodosVoos() {
        return VooMapper.convertToVO(vooRepository.findAll());
    }

    public Voo cadastrarVoo(VooDTO form) {
     return vooRepository.save(new Voo(form));
    }

    public void alterarVoo(long idVoo, VooDTO form) {
        Optional<Voo> vooEntity = vooRepository.findById(idVoo);
        vooEntity.get().setNumero(form.getNumero());
      //  vooEntity.get().setDataHoraPartida(form.getDataHoraPartida());
        vooEntity.get().setOrigemAeroporto(form.getOrigemAeroporto());
        vooEntity.get().setDestinoAeroporto(form.getDestinoAeroporto());
        vooEntity.get().setFlagVooCancelado(form.getFlagVooCancelado());
        vooRepository.save(vooEntity.get());
    }

    public void cancelarVoo(long idVoo, Boolean flagVooCancelado) {
        Optional<Voo> vooEntity = vooRepository.findById(idVoo);
        vooEntity.get().setFlagVooCancelado(flagVooCancelado);
        vooRepository.save(vooEntity.get());
    }
}
