package com.francisco.proyectomf0968.repositorios;

public interface Dao<O,PK> {
	public Iterable<O> getAll();
	public O getOne(PK id);
	public O save(O objeto);
	public O update(O objeto);
	public void delete(PK id);
}
