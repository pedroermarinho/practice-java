package org.example.rinhabackend2024q1springbootjpa.service;

import org.example.rinhabackend2024q1springbootjpa.dtos.ExtratoDTO;
import org.example.rinhabackend2024q1springbootjpa.dtos.LimiteESaldoDTO;
import org.example.rinhabackend2024q1springbootjpa.dtos.SaldoDTO;
import org.example.rinhabackend2024q1springbootjpa.dtos.TransacaoDTO;
import org.example.rinhabackend2024q1springbootjpa.forms.TransacaoForm;
import org.example.rinhabackend2024q1springbootjpa.model.Transacao;
import org.example.rinhabackend2024q1springbootjpa.repositories.SaldoRepository;
import org.example.rinhabackend2024q1springbootjpa.repositories.TransacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClienteService {
    private final SaldoRepository saldoRepository;
    private final TransacaoRepository transacaoRepository;

    public ClienteService(SaldoRepository saldoRepository, TransacaoRepository transacaoRepository) {
        this.saldoRepository = saldoRepository;
        this.transacaoRepository = transacaoRepository;
    }


    public LimiteESaldoDTO novaTransacao(Integer clientId, TransacaoForm transacaoForm) {
        validationClient(clientId);
        if (!transacaoForm.tipo().equals('d') && !transacaoForm.tipo().equals('c')) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Tipo de transação inválido");
        }

        final var saldo = saldoRepository.findByIdForUpdate(clientId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        if (transacaoForm.tipo() == 'd' && (Math.abs(saldo.getValor() - transacaoForm.valor()) >= saldo.getLimite())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Valor da transação excede o limite");
        }

        var trasacao = new Transacao();
        trasacao.setClienteId(clientId);
        trasacao.setValor(transacaoForm.valor());
        trasacao.setTipo(transacaoForm.tipo());
        trasacao.setDescricao(transacaoForm.descricao());
        trasacao.setRealizadaEm(LocalDateTime.now());
        transacaoRepository.save(trasacao);


        if (transacaoForm.tipo() == 'd') {
            saldo.setValor(saldo.getValor() - transacaoForm.valor());
        } else {
            saldo.setValor(saldo.getValor() + transacaoForm.valor());
        }

        saldoRepository.save(saldo);


        return new LimiteESaldoDTO(saldo.getLimite(), saldo.getValor());
    }


    public ExtratoDTO extrato(Integer clientId) {
        validationClient(clientId);
        final var saldo = saldoRepository.findById(clientId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        final var transacoes = transacaoRepository.findTop2ByClienteIdOrderByRealizadaEmDesc(clientId);

        final var saldoDTO = new SaldoDTO(saldo.getValor(), LocalDateTime.now(), saldo.getLimite());
        final var transacoesDTO = transacoes.stream().map(transacao -> new TransacaoDTO(transacao.getValor(), transacao.getTipo(), transacao.getDescricao(), transacao.getRealizadaEm())).toList();

        if (transacoesDTO.isEmpty()) {
            final var cleanSaldoDTO = new SaldoDTO(0, null, saldo.getLimite());
            return new ExtratoDTO(cleanSaldoDTO, List.of());
        }

        return new ExtratoDTO(saldoDTO, transacoesDTO);
    }

    private void validationClient(Integer clientId) {
        if (clientId == null || clientId < 1 || clientId > 6) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }
    }
}
