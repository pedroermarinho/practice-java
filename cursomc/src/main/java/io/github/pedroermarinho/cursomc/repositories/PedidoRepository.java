package io.github.pedroermarinho.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.pedroermarinho.cursomc.domain.Pedido;

@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Integer>{

}
