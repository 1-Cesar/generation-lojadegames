package com.projeto.lojadegames.service;

import java.nio.charset.Charset;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projeto.lojadegames.dto.UsuarioCredentialsDTO;
import com.projeto.lojadegames.dto.UsuarioLoginDTO;
import com.projeto.lojadegames.model.Usuario;
import com.projeto.lojadegames.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private UsuarioCredentialsDTO credendialsDTO;
	private @Autowired UsuarioRepository repository;
	
	public ResponseEntity<Usuario> registrar (Usuario novoUsuario){
		Optional<Usuario> optional = repository.findByEmailUsuario(novoUsuario.getEmailUsuario());
		
		if(optional.isEmpty()) {
			novoUsuario.setSenhaUsuario(criptografarSenha(novoUsuario.getSenhaUsuario()));
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(novoUsuario));
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email já cadastrado!");
		}
	}

	private String criptografarSenha(String senhaUsuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senhaUsuario);
	}
	
	public ResponseEntity<UsuarioCredentialsDTO> login (@Valid UsuarioLoginDTO dto){
		return repository.findByEmailUsuario(dto.getEmail()).map(resp -> {
			BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder();
			
			if (encoder.matches(dto.getPasswd(), resp.getSenhaUsuario())) {
				credendialsDTO = new UsuarioCredentialsDTO(
						basicTokenGenerator(dto.getEmail(), dto.getPasswd()),
						resp.getIdUsuario(),
						resp.getEmailUsuario());
				return ResponseEntity.status(HttpStatus.OK).body(credendialsDTO);
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha inválida!");
			}		
		}).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não existe!");
		});
	}

	private String basicTokenGenerator(String email, String passwd) {
		String structure = email + ":" + passwd;
		byte[] structureBase64 = Base64.encodeBase64(structure.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(structureBase64);
	}

}
