package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.LocalBean;
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
		Vector<ProductoBean> productos=new Vector<ProductoBean>();
		try
		{
		Connection con= DAO.obtenerConexion();
		Statement stmt= con.createStatement();
		ResultSet rs= stmt.executeQuery("select * from productos");
		ProductoBean producto=null;
		while(rs.next())
		{
			producto=new ProductoBean();
			producto.setId(rs.getInt("id"));
			producto.setNproducto(rs.getString("nproducto"));
			producto.setDescripcion(rs.getString("descripcion"));
			producto.setCategoria_id(rs.getInt("categoria_id"));
			producto.setPrecio(rs.getFloat("precio"));
			productos.add(producto);
		}
		
		}catch(Exception E)
		{
			System.out.print(E.getMessage());
		}
		return productos;

	}

	@Override
	public ProductoBean buscarPorID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
