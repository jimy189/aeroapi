package com.br.aeroapi.controller;

import com.br.aeroapi.dto.CadastroVooDTO;
import com.br.aeroapi.dto.VooDTO;
import com.br.aeroapi.service.VooService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voos")
public class VooController {
    @Autowired
    private VooService vooService;


    @GetMapping
   // @PreAuthorize("hasRole('USER')") // Defina a permissão necessária para acessar esta rota
    public ResponseEntity<?> getlistarVoos() {
        return ResponseEntity.ok(vooService.listarTodosVoos());
    }





    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CadastroVooDTO form) throws Exception {
        if(form.getOrigemAeroporto() == form.getDestinoAeroporto()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: O voo não pode ter como origem e destino no mesmo aeroporto!");
        }
        if(form.getClasses().size() == 0){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Falha na expectativa: Os voos devem possuir no mínimo uma classe!");
        }
       vooService.cadastrarVoo(form);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<?> alterarVoo(@RequestParam(value = "idVoo" , required = true) long idVoo, @Valid @RequestBody VooDTO form) {

        vooService.alterarVoo(idVoo,form);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping
    public ResponseEntity<?> cancelarVoo(@RequestParam(value = "idVoo" , required = true) long idVoo, @RequestParam(value = "flagVooCancelado" , required = true) Boolean flagVooCancelado) {
        vooService.cancelarVoo(idVoo,flagVooCancelado);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
