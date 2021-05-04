package com.zup.adressController.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.adressController.model.Usuario;
import com.zup.adressController.repository.UsuarioRepository;
@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;
		public Usuario CadastrarUsuario (Usuario usuario) {
			return this.repository.save(usuario);
		}
}
