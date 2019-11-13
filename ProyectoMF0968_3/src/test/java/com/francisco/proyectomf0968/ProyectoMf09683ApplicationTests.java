package com.francisco.proyectomf0968;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.francisco.proyectomf0968.entidades.Almacen;
import com.francisco.proyectomf0968.entidades.Usuario;
import com.francisco.proyectomf0968.repositorios.AlmacenesDaoJPA;
import com.francisco.proyectomf0968.repositorios.UsuarioDaoJPA;

@SpringBootTest
class ProyectoMf09683ApplicationTests {
	@Autowired
	private UsuarioDaoJPA userRepo;
	@Autowired
	private AlmacenesDaoJPA almacenesRepo;
	@Autowired
	private BCryptPasswordEncoder pEncoder;
	@Test
	void contextLoads() {
	}
	@Test
	void crearAdminTest() {
		Usuario user = new Usuario();
		user.setApellidos("García García");
		user.setNombre("Francisco");
		user.setUsername("admin");
		user.setPassword(pEncoder.encode("adminPass"));
		user.setEdad(26);
		user.setSexo("M");
		user.setRole("ROLE_ADMIN");
		user.setEnabled(false);
		Usuario respuesta = userRepo.save(user);
		assertTrue(respuesta.getPassword().equalsIgnoreCase(user.getPassword()));
	}
	@Test
	void crearUsuarioTest() {
		Usuario user = new Usuario();
		user.setApellidos("Lete");
		user.setNombre("Javier");
		user.setUsername("user");
		user.setPassword(pEncoder.encode("userPass"));
		user.setEdad(40);
		user.setSexo("M");
		user.setRole("ROLE_USER");
		user.setEnabled(false);
		Usuario respuesta = userRepo.save(user);
		assertTrue(respuesta.getPassword().equalsIgnoreCase(user.getPassword()));
	}
	@Test
	void crearAlmacenTest() {
		Almacen almacen = new Almacen();
		almacen.setNombre("Asturias");
		almacen.setUbicacion("enlace de google maps");
		almacenesRepo.save(almacen);
	}
}
