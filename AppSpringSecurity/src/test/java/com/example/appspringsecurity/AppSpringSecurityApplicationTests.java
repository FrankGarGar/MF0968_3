package com.example.appspringsecurity;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.appspringsecurity.entidades.Usuario;
import com.example.appspringsecurity.repositorios.jpa.UsuarioDaoJPA;

@SpringBootTest
class AppSpringSecurityApplicationTests {
	
	@Inject
	private UsuarioDaoJPA userRepo;
	
	@Inject
	private BCryptPasswordEncoder pEncoder;
	@Test
	void crearUsuarioTest() {
		Usuario user = new Usuario();
		user.setApellidos("Garcia Garcia");
		user.setNombre("Francisco");
		user.setUsername("admin2");
		user.setPassword(pEncoder.encode("admin2"));
		user.setEdad(26);
		user.setSexo('M');
		user.setRole("ADMIN");
		user.setEnabled(false);
		Usuario respuesta = userRepo.save(user);
		assertTrue(respuesta.getPassword().equalsIgnoreCase(user.getPassword()));
	}

}
