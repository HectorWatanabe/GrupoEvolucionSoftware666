package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.CategorieBean;
import beans.DistritoBean;

public class DistritoDaoImpl extends DAO implements DistritoDao{

	@Override
	public Vector<DistritoBean> listarTodos() {
		Vector<DistritoBean> distritos=new Vector<DistritoBean>();
		try
		{
		Connection con= DAO.obtenerConexion();
		Statement stmt= con.createStatement();
		ResultSet rs= stmt.executeQuery("select * from distrito");
		DistritoBean distrito=null;
		while(rs.next())
		{
			distrito=new DistritoBean();
			distrito.setId(rs.getInt("id"));
			distrito.setNdistrito(rs.getString("ndistrito"));
			distritos.add(distrito);
		}
		
		}catch(Exception E)
		{
			System.out.print(E.getMessage());
		}
		return distritos;
	}

}
