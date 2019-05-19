package com.example.demo;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value="/cliente")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteResource {
	
	@Autowired
	private ClienteRepository service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> cliente = service.findAll();
		return ResponseEntity.ok().body(cliente);
	}
		
	@PostMapping
	public ResponseEntity<?> salvar(@Valid @RequestBody Cliente cliente) {
		service.save(cliente);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(cliente.getCodigo()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<?> atualizar(@Valid @RequestBody Cliente cliente) {
		service.save(cliente);
	    return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value="{codigo}")
	public ResponseEntity<?> excluir(@PathVariable Integer codigo) {
		try {
			service.deleteById(codigo);
			return ResponseEntity.ok(codigo);	
		} catch(EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
	}

}