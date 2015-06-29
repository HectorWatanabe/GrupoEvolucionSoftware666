package pe.com.service;

import java.util.List;

import pe.com.modelo.Producto;

public interface ProductoDao {
	
	public boolean agregar(Producto producto);
	
	public List<Producto> listar();
	
	public boolean borrar(String id);
	public Producto obtenerid(String id);
	public boolean editar(Producto producto);

}
