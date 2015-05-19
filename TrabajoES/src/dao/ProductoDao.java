package dao;

import java.util.Vector;

import beans.LocalBean;
import beans.ProductoBean;

public interface ProductoDao {
	public boolean insertar(ProductoBean producto);

	public boolean borrar(String id);
	public Vector<ProductoBean> listarTodos();
	
	public ProductoBean obtenerid(String id);
	public boolean editar(ProductoBean producto);

}
