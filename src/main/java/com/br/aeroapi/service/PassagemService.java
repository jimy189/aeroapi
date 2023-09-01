package com.br.aeroapi.service;

import com.br.aeroapi.dto.CompraPassagemDTO;
import com.br.aeroapi.dto.EtiquetaBagagemDTO;
import com.br.aeroapi.dto.PassageiroDTO;
import com.br.aeroapi.dto.PassagemDTO;
import com.br.aeroapi.dto.VoucherDTO;
import com.br.aeroapi.mapper.CompraMapper;
import com.br.aeroapi.model.Bagagem;
import com.br.aeroapi.model.Classe;
import com.br.aeroapi.model.Compra;
import com.br.aeroapi.model.EtiquetaBagagem;
import com.br.aeroapi.model.Passageiro;
import com.br.aeroapi.model.Passagem;
import com.br.aeroapi.model.Voucher;
import com.br.aeroapi.repository.BagagemRepository;
import com.br.aeroapi.repository.ClasseRepository;
import com.br.aeroapi.repository.CompraRepository;
import com.br.aeroapi.repository.EtiquetaBagagemRepository;
import com.br.aeroapi.repository.PassageiroRepository;
import com.br.aeroapi.repository.PassagemRepository;
import com.br.aeroapi.repository.VoucherRepository;
import com.br.aeroapi.util.Util;
import com.br.aeroapi.vo.CompraVO;
import com.br.aeroapi.vo.VooPassageiroVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PassagemService {
    @Autowired
    private PassagemRepository passagemRepository;
    @Autowired
    private PassageiroRepository passageiroRepository;
    @Autowired
    private EtiquetaBagagemRepository etiquetaBagagemRepository;
    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private BagagemRepository bagagemRepository;

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ClasseRepository classeRepository;

    public Passagem cadastrarPassagem(PassagemDTO form) {
        // Gerar um UUID aleatório
        UUID numeroUnico = UUID.randomUUID();
        form.setNumeroIdentificacao(numeroUnico.toString());
        return passagemRepository.save(new Passagem(form));
    }

    public void alterarPreco(Long idPassagem, double precoTotal) {
        Optional<Passagem> passagemEntity = passagemRepository.findById(idPassagem);
        passagemEntity.get().setPrecoTotal(precoTotal);
        passagemRepository.save(passagemEntity.get());
    }

    public void comprarPassagem(List<CompraPassagemDTO> form) throws ParseException {
        for (CompraPassagemDTO listPassagem : form) {
            Passagem passagem = passagemRepository.findByIdAndVoo(listPassagem.getIdPassagem(), listPassagem.getIdVoo());
            if (passagem != null) {
                PassageiroDTO passageiroDTO = new PassageiroDTO();
                passageiroDTO.setCpf(listPassagem.getCpf());
                passageiroDTO.setNome(listPassagem.getNome());
                passageiroDTO.setDataNascimento(listPassagem.getDataNascimento());
                Passageiro passageiro = passageiroRepository.save(new Passageiro(passageiroDTO));

                passagem.setPassageiro(passageiro.getId());
                passagemRepository.save(passagem);
                if (listPassagem.getFlagBagagem()) {
                    passagem.setFlagBagagem(true);
                    passagem.setPrecoTotal(passagem.getPrecoTotal() + (passagem.getPrecoTotal()*0.10));
                    passagemRepository.save(passagem);
                    bagagemRepository.save(new Bagagem(passagem.getNumeroIdentificacao(), passagem.getId()));
                }else{
                    passagem.setFlagBagagem(false);
                    passagemRepository.save(passagem);
                }
                compraRepository.save(new Compra(passagem.getVoo(), passagem.getId(), passageiro.getCpf()));
                //Remover assento
                Optional<Classe> classe = classeRepository.findById(passagem.getClasse());
                classe.get().setCapacidadeMaxima(classe.get().getCapacidadeMaxima()-1);
                classeRepository.save(classe.get());
            }
        }
    }

    public List<Passagem> obterPassagensPorCPF(String cpf) {
        Passageiro passageiro = passageiroRepository.findByCpf(cpf);
        List<Passagem> passagemList = passagemRepository.findByPassageiro(passageiro.getId());
        return passagemList;
    }

    public Voucher emitirVoucher(VoucherDTO form) {
        return voucherRepository.save(new Voucher(form));
    }

    public EtiquetaBagagem emitirEtiquetaBagagem(EtiquetaBagagemDTO form) {
        return etiquetaBagagemRepository.save(new EtiquetaBagagem(form));
    }

    public VooPassageiroVO listarPassageirosVoo(Long id) {
        List<Passagem> passagemList = passagemRepository.findByVoo(id);
        VooPassageiroVO vooPassageiroVO = new VooPassageiroVO();
        List<String> listaNomes = new ArrayList<>();
        vooPassageiroVO.setIdVoo(id);
        for (Passagem listarPassagem : passagemList) {
            Passageiro passageiro = passageiroRepository.findByIdPassageiro(listarPassagem.getPassageiro());
            if (passageiro.getNome() != null) {
                listaNomes.add(passageiro.getNome());
                vooPassageiroVO.setNomePassageiros(listaNomes);
            }

        }
        return vooPassageiroVO;
    }


    public void cancelarComprarPassagem(Long idPassagem, Long idVoo, Long idPassageiro) {
        Passagem passagem = passagemRepository.findByIdAndVooAndPassageiro(idPassagem, idVoo, idPassageiro);
        passagem.setPassageiro(null);
        Passageiro passageiro = passageiroRepository.findByIdPassageiro(idPassageiro);
        Compra compraCancelada = compraRepository.findByIdVooAndIdPassagemAndCpf(idVoo,idPassagem, passageiro.getCpf());
        passagemRepository.save(passagem);
        compraRepository.delete(compraCancelada);

    }

    public List<CompraVO> listarCompras() {
      return   CompraMapper.convertToVO(compraRepository.findAll());
    }

    public List<Passagem> passagemVoo(Long origem, Long destino, String data, Double precoPassagem) {
        Timestamp dataFormatada = Util.formatarData(data);
    return passagemRepository.findPassageiroComData(origem,destino, dataFormatada, precoPassagem);
    }
}
