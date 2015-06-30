package pe.com.service;

import java.util.List;

import pe.com.modelo.Categoria;
import pe.com.modelo.Producto;


public interface CategoriaDao {
	
	public boolean agregar(Categoria categoria);
	public List<Categoria> listar();
	public boolean borrar(String id);
	public Categoria obtenerid(String id);
	public boolean editar(Categoria categoria);
	public Categoria obtenercat(String ncategoria);
	public List<Producto> listar2(String id);
}
