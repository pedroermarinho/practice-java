package io.github.pedroermarinho.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.pedroermarinho.cursomc.domain.Cliente;
import io.github.pedroermarinho.cursomc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	 public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Cliente cliente = service.buscar(id);
		
		return ResponseEntity.ok().body(cliente);
		
	}
}
