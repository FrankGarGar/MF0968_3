package com.example.bancoinventado.repositorios;

public interface Dao<O,PK> {
	public Iterable<O> getAll();
	public O getOne(PK id);
	public O insert(O objeto);
	public O update(O objeto);
	public void delete(PK id);
}
