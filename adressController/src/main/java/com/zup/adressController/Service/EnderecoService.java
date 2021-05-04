package com.zup.adressController.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.adressController.model.Endereco;
import com.zup.adressController.repository.EnderecoRepository;
@Service
public class EnderecoService {
		@Autowired
	private EnderecoRepository repository;
		public Endereco CadastrarEndereco (Endereco endereco) {
		return this.repository.save(endereco);
	}

}
