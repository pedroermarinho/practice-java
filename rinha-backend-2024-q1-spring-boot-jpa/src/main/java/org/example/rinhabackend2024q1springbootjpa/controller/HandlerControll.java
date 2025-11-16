package org.example.rinhabackend2024q1springbootjpa.controller;


import jakarta.validation.Valid;
import org.example.rinhabackend2024q1springbootjpa.dtos.ExtratoDTO;
import org.example.rinhabackend2024q1springbootjpa.dtos.LimiteESaldoDTO;
import org.example.rinhabackend2024q1springbootjpa.forms.TransacaoForm;
import org.example.rinhabackend2024q1springbootjpa.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class HandlerControll {

    private final ClienteService clienteService;

    public HandlerControll(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Transactional
    @PostMapping("/clientes/{clientId}/transacoes")
    public ResponseEntity<LimiteESaldoDTO> novaTransacao(@PathVariable Integer clientId, @RequestBody @Valid TransacaoForm transacaoForm) {
        return ResponseEntity.status(HttpStatus.valueOf(200)).body(clienteService.novaTransacao(clientId, transacaoForm));
    }

    @Transactional
    @GetMapping("/clientes/{clientId}/extrato")
    public ResponseEntity<ExtratoDTO> extrato(@PathVariable Integer clientId) {
        return ResponseEntity.status(HttpStatus.valueOf(200)).body(clienteService.extrato(clientId));
    }
}
