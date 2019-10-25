package com.example.appspringsecurity.servicios;

public interface ServiciosDAOS<T,PK> {
	public T getOne(PK id);
	public Iterable<T> getAll();
	public T save(T user);
	public T update(T user);
	public void delete(PK id);
}
