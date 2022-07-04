package io.github.pedroermarinho.aluguel_de_carro_fx.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.pedroermarinho.aluguel_de_carro_fx.domain.entities.AluguelEntity;

@Repository
public interface AluguelRepository extends JpaRepository<AluguelEntity,Long> {
    
}
