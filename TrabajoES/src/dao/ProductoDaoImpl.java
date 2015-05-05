package dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Vector;

import beans.ProductoBean;

public class ProductoDaoImpl extends DAO implements ProductoDao {

	@Override
	public boolean insertar(ProductoBean producto) {
		boolean flag = false;
		
		try {
			Connection conexion = DAO.obtenerConexion();
			Statement stmt = conexion.createStatement();
			
			int filas = stmt.executeUpdate("insert into productos "
			+ "(nproducto, descripcion, categoria_id, precio) "
			+ "values ('"+producto.getNproducto()+"', "
			+ "'"+producto.getDescripcion()+"', "
			+ "'"+producto.getCategoria_id()+"', "
			+ "'"+producto.getPrecio()+"')");

			conexion.close();
			
			if(filas==1){
				flag = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public Vector<ProductoBean> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoBean buscarPorID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
