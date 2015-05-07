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
}
