package com.projeto.lojadegames.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.lojadegames.dto.UsuarioCredentialsDTO;
import com.projeto.lojadegames.dto.UsuarioLoginDTO;
import com.projeto.lojadegames.model.Usuario;
import com.projeto.lojadegames.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usuario")
public class UsuarioController {
	
	private @Autowired UsuarioService service;
	
	@PostMapping("/cadastro")
	public ResponseEntity<Usuario> cadastro(@Valid @RequestBody Usuario novoUsuario){
		return service.registrar(novoUsuario);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UsuarioCredentialsDTO> login (@Valid @RequestBody UsuarioLoginDTO loginDto){
		return service.login(loginDto);
	}
	
}
