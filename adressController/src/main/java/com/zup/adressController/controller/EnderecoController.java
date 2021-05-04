
package com.zup.adressController.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.zup.adressController.model.Endereco;
import com.zup.adressController.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository repository;
	 
	@GetMapping
	public ResponseEntity<List<Endereco>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<Endereco> getById(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/cep/{cep}")
	public ResponseEntity<List<Endereco>> getByCep(@PathVariable String cep){
		return ResponseEntity.ok(repository.findAllByCep(cep));
	}
	
	@PostMapping
	public ResponseEntity<Endereco> post (@RequestBody Endereco endereco){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(endereco));
	}
	
	@PutMapping
	public ResponseEntity<Endereco> put (@RequestBody Endereco endereco){
		return ResponseEntity.ok(repository.save(endereco));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}

}
