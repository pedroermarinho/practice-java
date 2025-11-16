package org.example.rinhabackend2024q1springbootjpa.repositories;

import org.example.rinhabackend2024q1springbootjpa.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    List<Transacao> findTop2ByClienteIdOrderByRealizadaEmDesc(Integer clienteId);
}
