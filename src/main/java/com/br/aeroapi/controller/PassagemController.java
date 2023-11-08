package com.br.aeroapi.controller;

import com.br.aeroapi.dto.CompraPassagemDTO;
import com.br.aeroapi.dto.EtiquetaBagagemDTO;
import com.br.aeroapi.dto.PassagemDTO;
import com.br.aeroapi.dto.VoucherDTO;
import com.br.aeroapi.model.Passagem;
import com.br.aeroapi.model.Voo;
import com.br.aeroapi.repository.PassagemRepository;
import com.br.aeroapi.repository.VooRepository;
import com.br.aeroapi.service.PassagemService;
import com.br.aeroapi.util.Util;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passagem")
public class PassagemController {
    @Autowired
    private PassagemService passagemService;

    @Autowired
    private PassagemRepository passagemRepository;

    @Autowired
    private VooRepository vooRepository;



    @PostMapping("/cadastrapassagem")
    public ResponseEntity<?> create(@Valid @RequestBody PassagemDTO form) {
       passagemService.cadastrarPassagem(form);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/alterarpreco")
    public ResponseEntity<?> alterarPreco(@RequestParam(value = "idPassagem" , required = true) Long idPassagem, @RequestParam(value = "precoTotal" , required = true) double precoTotal) {
        passagemService.alterarPreco(idPassagem,precoTotal);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/passageirolistavoo")
    public ResponseEntity<?> listarPassageiros(@RequestParam(value = "idVoo" , required = true) Long idVoo) {
        return ResponseEntity.ok(passagemService.listarPassageirosVoo(idVoo));
    }

    @GetMapping("/passagemvoo")
    public ResponseEntity<?> passagemVoo(@RequestParam(value = "origem" , required = true) Long origem,
                                         @RequestParam(value = "destino" , required = true) Long destino,
                                         @RequestParam(value = "data" , required = true) String data,
                                         @RequestParam(value = "precoPassagem" , required = false) Double precoPassagem) {
        return ResponseEntity.ok(passagemService.passagemVoo(origem,destino,data,precoPassagem));
    }


    @PatchMapping("/comprarpassagem")
    public ResponseEntity<?> comprarPassagem(@Valid @RequestBody List<CompraPassagemDTO> formList) throws ParseException {
        passagemService.comprarPassagem(formList);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/compras")
    public ResponseEntity<?> listarCompras() {
        passagemService.listarCompras();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PatchMapping("/cancelarcompra")
    public ResponseEntity<?> cancelarComprarPassagem(@RequestParam(value = "idPassagem" , required = true) Long idPassagem,
                                                     @RequestParam(value = "idVoo" , required = true) Long idVoo,
                                                     @RequestParam(value = "idPassageiro" , required = true) Long idPassageiro) {
        passagemService.cancelarComprarPassagem(idPassagem, idVoo, idPassageiro );
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/cpf")
    public ResponseEntity<?> obterPorCPFPassagem(@RequestParam(value = "cpf" , required = true) String cpf) {
        return ResponseEntity.ok(passagemService.obterPassagensPorCPF(cpf));
    }

    @PostMapping("/emitirvoucher")
    public ResponseEntity<?> emitirVoucher(@Valid @RequestBody VoucherDTO form) {

        Date tempoEmissao = new Date(); //  hora atual

        Optional<Voo>  voo = vooRepository.findById(Long.parseLong(form.getNumeroVoo()));

        boolean dentroDoLimite = Util.verificaTempoEmissao(tempoEmissao, voo.get().getDataHoraPartida());

        if (!dentroDoLimite) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro:  A emissão do voucher está fora do limite de 5 horas antes do voo!!");
        }
        passagemService.emitirVoucher(form);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/emitiretiquetabagagem")
    public ResponseEntity<?> emitirEtiquetaBagagem(@Valid @RequestBody EtiquetaBagagemDTO form) {
        Date tempoEmissao = new Date(); //  hora atual

        Optional<Voo>  voo = vooRepository.findById(Long.parseLong(form.getNumeroVoo()));
        boolean dentroDoLimite = Util.verificaTempoEmissao(tempoEmissao, voo.get().getDataHoraPartida());

        if (!dentroDoLimite) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro:  A emissão da etiqueta está fora do limite de 5 horas antes do voo!");
        }

        Optional<Passagem> passagem = passagemRepository.findById(Long.parseLong(form.getNumeroPassagem()));
        if(!passagem.get().getFlagBagagem()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: Flag da bagagem falsa então não pode criar etiqueta de bagagem!");
        }
        passagemService.emitirEtiquetaBagagem(form);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }



}
