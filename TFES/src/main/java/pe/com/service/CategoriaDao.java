package pe.com.service;

import java.util.List;

import pe.com.modelo.Categoria;


public interface CategoriaDao {
	
	public boolean agregar(Categoria categoria);
	
	public List<Categoria> listar();
}
