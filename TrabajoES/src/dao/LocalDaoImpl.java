package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.CategorieBean;
import beans.LocalBean;

public class LocalDaoImpl extends DAO implements LocalDao{

	public boolean borrar(String id)
	{
		boolean flag=false;
	
		try {
			Connection con= DAO.obtenerConexion();
			Statement stmt= con.createStatement();
			
			int filas= stmt.executeUpdate("delete from local where id=" + id);
			
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
	
	@Override
	public boolean insertar(LocalBean local) {

		boolean flag = false;
		
		try {
			Connection conexion = DAO.obtenerConexion();
			Statement stmt = conexion.createStatement();
			
			int filas = stmt.executeUpdate("insert into local "
			+ "(nlocal, direccion, telefono, correo,distrito) "
			+ "values ('"+local.getNlocal()+"', "
			+ "'"+local.getDireccion()+"', "
			+ "'"+local.getTelefono()+"', "
			+ "'"+local.getCorreo()+"',"
			+ "'"+local.getDistrito()+"')");

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
	public Vector<LocalBean> listarTodos() {

		Vector<LocalBean> locales=new Vector<LocalBean>();
		try
		{
		Connection con= DAO.obtenerConexion();
		Statement stmt= con.createStatement();
		ResultSet rs= stmt.executeQuery("select * from local");
		LocalBean local=null;
		while(rs.next())
		{
			local=new LocalBean();
			local.setLocal_id(rs.getInt("id"));
			local.setNlocal(rs.getString("nlocal"));
			local.setDireccion(rs.getString("direccion"));
			local.setDistrito(rs.getString("distrito"));
			local.setCorreo(rs.getString("correo"));
			local.setTelefono(rs.getInt("telefono"));
			locales.add(local);
		}
		
		}catch(Exception E)
		{
			System.out.print(E.getMessage());
		}
		return locales;

	}

	@Override
	public LocalBean obtenerid(String id) {
		LocalBean local=null;
		try {
			Connection conexion = DAO.obtenerConexion();
			Statement stmt = conexion.createStatement();
			
			ResultSet rs =
					stmt.executeQuery("select * from local where id=" + id);
			
			if( rs.next() ){
				local = new LocalBean();
				local.setLocal_id( rs.getInt("id") );
				local.setCorreo( rs.getString("correo") );
				local.setDireccion( rs.getString("direccion") );
				local.setNlocal( rs.getString("nlocal") );
				local.setTelefono(Integer.parseInt( rs.getString("telefono") ));
				local.setDistrito( rs.getString("distrito") );
				
			}
		
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		
		return local;
	}

	@Override
	public boolean editar(LocalBean local) {
			boolean flag = false;
		
		try {
			Connection conexion = DAO.obtenerConexion();
			Statement stmt = conexion.createStatement();
			
			int filas = stmt.executeUpdate("update local "
					+ " set nlocal='" + local.getNlocal() + "',"
					+ " direccion='" + local.getDireccion() + "',"
					+ " correo='" + local.getCorreo() + "',"
					+ " telefono='" + local.getTelefono() + "',"
					+ " distrito='" + local.getDistrito() + "'"
					+ " where id=" + local.getLocal_id() );

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
