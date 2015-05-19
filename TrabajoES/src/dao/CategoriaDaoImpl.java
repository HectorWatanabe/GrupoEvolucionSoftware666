package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.CategorieBean;

public class CategoriaDaoImpl extends DAO implements CategoriaDao{
	@Override
	public Vector<CategorieBean> listarTodos() {

	Vector<CategorieBean> categorias=new Vector<CategorieBean>();
	try
	{
	Connection con= DAO.obtenerConexion();
	Statement stmt= con.createStatement();
	ResultSet rs= stmt.executeQuery("select * from categoria");
	CategorieBean categoria=null;
	while(rs.next())
	{
		categoria=new CategorieBean();
		categoria.setId(rs.getInt("id"));
		categoria.setNcategoria(rs.getString("ncategoria"));
		categorias.add(categoria);
	}
	
	}catch(Exception E)
	{
		System.out.print(E.getMessage());
	}
	return categorias;

	}
	
	public boolean borrar(String id)
	{
		boolean flag=false;
	
		try {
			Connection con= DAO.obtenerConexion();
			Statement stmt= con.createStatement();
			
			int filas= stmt.executeUpdate("delete from categoria where id=" + id);
			
			con.close();
			
			if(filas==1){
				flag = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		return flag;
	}
	
	public boolean insertar(CategorieBean categoria) {

		boolean flag = false;
		
		try {
			Connection conexion = DAO.obtenerConexion();
			Statement stmt = conexion.createStatement();
			
			int filas = stmt.executeUpdate("insert into categoria "
			+ "(ncategoria) "
			+ "values ('"+categoria.getNcategoria()+"')");

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
	public CategorieBean obtenerid(String id) {
		CategorieBean categoria=null;
		try {
			Connection conexion = DAO.obtenerConexion();
			Statement stmt = conexion.createStatement();
			
			ResultSet rs =
					stmt.executeQuery("select * from categoria where id=" + id);
			
			if( rs.next() ){
				categoria = new CategorieBean();
				categoria.setId( rs.getInt("id") );
				categoria.setNcategoria( rs.getString("ncategoria") );
				
			}
		
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		
		return categoria;
	}

	@Override
	public boolean editar(CategorieBean categoria) {
boolean flag = false;
		
		try {
			Connection conexion = DAO.obtenerConexion();
			Statement stmt = conexion.createStatement();
			
			int filas = stmt.executeUpdate("update categoria "
					+ " set ncategoria='" + categoria.getNcategoria() + "'"
					+ " where id=" + categoria.getId() );

			conexion.close();
			
			if(filas==1){
				flag = true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		return flag;
	}
}