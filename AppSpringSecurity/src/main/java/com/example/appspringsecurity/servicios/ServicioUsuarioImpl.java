package com.example.appspringsecurity.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.appspringsecurity.entidades.Usuario;
import com.example.appspringsecurity.repositorios.jpa.UsuarioDaoJPA;
@Service
public class ServicioUsuarioImpl implements UserDetailsService,ServicioUsuario{
	
	@Inject
	private UsuarioDaoJPA userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = userRepo.findByUsername(username);
		
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(user.getRole()));
		UserDetails userDetails = new User(user.getUsername(),user.getPassword(),roles);
		return userDetails;
	}
	@Override
	public Usuario getOne(Long id) {
		return userRepo.findById(id);
	}
	@Override
	public Iterable<Usuario> getAll() {
		return userRepo.getAll();
	}
	@Override
	public Usuario save(Usuario user) {
		return userRepo.save(user);
	}
	@Override
	public Usuario update(Usuario user) {
		return userRepo.save(user);
	}
	@Override
	public void delete(Long id) {
		userRepo.delete(id);
		
	}
	public Usuario getByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
}
