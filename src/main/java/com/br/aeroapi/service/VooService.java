package com.br.aeroapi.service;

import com.br.aeroapi.dto.CadastroVooDTO;
import com.br.aeroapi.dto.ClasseDTO;
import com.br.aeroapi.dto.VooDTO;
import com.br.aeroapi.mapper.VooMapper;
import com.br.aeroapi.model.Classe;
import com.br.aeroapi.model.Voo;
import com.br.aeroapi.repository.ClasseRepository;
import com.br.aeroapi.repository.VooRepository;
import com.br.aeroapi.vo.VooVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VooService {
    @Autowired
    private VooRepository vooRepository;

    @Autowired
    private ClasseRepository classeRepository;




    public List<VooVO> listarTodosVoos() {
        return VooMapper.convertToVO(vooRepository.findAll());
    }

    public void cadastrarVoo(CadastroVooDTO form)  {
        VooDTO vooDTOForm = new VooDTO();
        vooDTOForm.setNumero(form.getNumero());
        vooDTOForm.setDataHoraPartida(form.getDataHoraPartida());
        vooDTOForm.setDestinoAeroporto(form.getDestinoAeroporto());
        vooDTOForm.setFlagVooCancelado(form.getFlagVooCancelado());
        Voo voo = vooRepository.save(new Voo(vooDTOForm));
        for (ClasseDTO classeDto: form.getClasses()) {
            classeRepository.save(new Classe(voo.getId(),classeDto));
        }
    }

    public void alterarVoo(long idVoo, VooDTO form) {
        Optional<Voo> vooEntity = vooRepository.findById(idVoo);
        vooEntity.get().setNumero(form.getNumero());
      //  vooEntity.get().setDataHoraPartida(form.getDataHoraPartida());
        vooEntity.get().setOrigemAeroporto(form.getOrigemAeroporto());
        vooEntity.get().setOrigemAeroporto(form.getDestinoAeroporto());
        vooEntity.get().setFlagVooCancelado(form.getFlagVooCancelado());
        vooRepository.save(vooEntity.get());
    }

    public void cancelarVoo(long idVoo, Boolean flagVooCancelado) {
        Optional<Voo> vooEntity = vooRepository.findById(idVoo);
        vooEntity.get().setFlagVooCancelado(flagVooCancelado);
        vooRepository.save(vooEntity.get());
    }




}
