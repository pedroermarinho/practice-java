package io.github.pedroermarinho.aluguel_de_carro_fx.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.pedroermarinho.aluguel_de_carro_fx.domain.entities.CarroEntity;

@Repository
public interface CarroRepository extends JpaRepository<CarroEntity,Long> {
    
}
