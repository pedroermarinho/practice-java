package io.github.pedroermarinho.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.pedroermarinho.cursomc.domain.Categoria;
import io.github.pedroermarinho.cursomc.domain.Cliente;
import io.github.pedroermarinho.cursomc.repositories.CategoriaRepository;
import io.github.pedroermarinho.cursomc.repositories.ClienteRepository;
import io.github.pedroermarinho.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Cliente buscar(Integer id)  {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}
