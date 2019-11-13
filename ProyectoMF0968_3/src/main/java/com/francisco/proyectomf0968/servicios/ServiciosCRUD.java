package com.francisco.proyectomf0968.servicios;

public interface ServiciosCRUD<T, L> {
	public T getOne(L id);
	public Iterable<T> getAll();
	public T save(T user);
	public T update(T user);
	public void delete(L id);
}
