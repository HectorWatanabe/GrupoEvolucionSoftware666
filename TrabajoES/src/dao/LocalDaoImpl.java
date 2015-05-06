package dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Vector;

import beans.LocalBean;

public class LocalDaoImpl extends DAO implements LocalDao{

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
			+ "'"+local.getDireccion()+"')");

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalBean buscarPorID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
