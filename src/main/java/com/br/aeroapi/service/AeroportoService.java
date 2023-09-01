package com.br.aeroapi.service;

import com.br.aeroapi.mapper.AeroportoMapper;
import com.br.aeroapi.model.Aeroporto;
import com.br.aeroapi.repository.AeroportoRepository;
import com.br.aeroapi.vo.AeroportoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AeroportoService {

    @Autowired
    private AeroportoRepository aeroportoRepository;

    public List<AeroportoVO> listarAeroportos() {
        return AeroportoMapper.convertToVO(aeroportoRepository.findAll());
    }


}
