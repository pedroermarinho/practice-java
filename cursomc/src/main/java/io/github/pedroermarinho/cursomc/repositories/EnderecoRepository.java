package io.github.pedroermarinho.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.pedroermarinho.cursomc.domain.Endereco;

@Repository
public interface EnderecoRepository  extends JpaRepository<Endereco, Integer>{

}
