package com.example.appspringsecurity.repositorios.jpa;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import com.example.appspringsecurity.entidades.CartItem;
import com.example.appspringsecurity.repositorios.Dao;

@Named
public class CartItemDaoJPA implements Dao<CartItem, Long>{
	@Inject
	private CartItemRepositorio itemRepo;

	@Override
	public Iterable<CartItem> getAll() {
		return itemRepo.findAll();
	}

	@Override
	public CartItem getOne(Long id) {
		return itemRepo.findById(id).get();
	}

	public Iterable<CartItem> saveAll(Set<CartItem> cartItems) {
		return itemRepo.saveAll(cartItems);
		
	}
	@Override
	public CartItem save(CartItem cartItem) {
		return itemRepo.save(cartItem);
	}
	@Override
	public CartItem update(CartItem cartItem) {
		return itemRepo.save(cartItem);
	}

	@Override
	public void delete(Long id) {
		itemRepo.deleteById(id);
	}
}
