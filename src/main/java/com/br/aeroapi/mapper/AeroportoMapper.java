package com.br.aeroapi.mapper;

import com.br.aeroapi.model.Aeroporto;
import com.br.aeroapi.vo.AeroportoVO;

import java.util.List;
import java.util.stream.Collectors;

public class AeroportoMapper {
    public static List<AeroportoVO> convertToVO(List<Aeroporto> questions) {

        return questions.stream().map(AeroportoVO::new).collect(Collectors.toList());
    }
}
