package com.br.aeroapi.mapper;

import com.br.aeroapi.model.Voo;
import com.br.aeroapi.vo.VooVO;

import java.util.List;
import java.util.stream.Collectors;

public class VooMapper {
    public static List<VooVO> convertToVO(List<Voo> questions) {

        return questions.stream().map(VooVO::new).collect(Collectors.toList());
    }
}
