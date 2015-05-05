package dao;

import java.util.Vector;
import beans.ProductoBean;

public interface ProductoDao {
	public boolean insertar(ProductoBean producto);

	public Vector<ProductoBean> listarTodos();
	
	public ProductoBean buscarPorID(int id);

}
