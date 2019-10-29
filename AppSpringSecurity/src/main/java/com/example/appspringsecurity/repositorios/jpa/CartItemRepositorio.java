package com.example.appspringsecurity.repositorios.jpa;

import org.springframework.data.repository.CrudRepository;

import com.example.appspringsecurity.entidades.CartItem;

public interface CartItemRepositorio extends CrudRepository<CartItem, Long>{

}
