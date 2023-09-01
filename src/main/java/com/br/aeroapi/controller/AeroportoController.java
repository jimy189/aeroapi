package com.br.aeroapi.controller;

import com.br.aeroapi.model.Aeroporto;
import com.br.aeroapi.service.AeroportoService;
import com.br.aeroapi.vo.AeroportoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aeroportos")
public class AeroportoController {

    @Autowired
    private AeroportoService aeroportoService;

    @GetMapping
    public List<AeroportoVO> listarAeroportos() {
        return aeroportoService.listarAeroportos();
    }




}
