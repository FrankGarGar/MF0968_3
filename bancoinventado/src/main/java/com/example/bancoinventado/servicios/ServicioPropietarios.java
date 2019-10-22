package com.example.bancoinventado.servicios;

public interface ServicioPropietarios<O,PK> {
	public Iterable<O> getAll();
	public O getOne(PK id);
	public O insert(O objeto);
	public O update(O objeto);
	public void delete(PK id);
}
