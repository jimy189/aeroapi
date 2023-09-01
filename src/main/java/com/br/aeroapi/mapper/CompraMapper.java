package com.br.aeroapi.mapper;

import com.br.aeroapi.model.Aeroporto;
import com.br.aeroapi.model.Compra;
import com.br.aeroapi.vo.AeroportoVO;
import com.br.aeroapi.vo.CompraVO;

import java.util.List;
import java.util.stream.Collectors;

public class CompraMapper {

    public static List<CompraVO> convertToVO(List<Compra> questions) {

        return questions.stream().map(CompraVO::new).collect(Collectors.toList());
    }
}
