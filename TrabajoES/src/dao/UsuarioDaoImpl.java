package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.UsuarioBean;
import util.MD5;

public class UsuarioDaoImpl extends DAO implements UsuarioDao {

	@Override
	public boolean ingresar(String usuario, String clave) {
boolean flag = false;
		
		try {
			Connection conexion = DAO.obtenerConexion();
			Statement stmt = conexion.createStatement();
			
			ResultSet rs  = stmt.executeQuery("select * from usuario "
					+ " where usuario='"+usuario+"' and clave='"+ MD5.crypt(clave)+"'");

			
			if(rs.next()){
				flag = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public boolean insertar(UsuarioBean usuario) {
boolean flag = false;
		
		try {
			Connection conexion = DAO.obtenerConexion();
			Statement stmt = conexion.createStatement();
			
			int filas = stmt.executeUpdate("insert into usuario "
			+ "(usuario,nusuario,ausuario,clave,nacimiento,tipo,dni,direccion,telefono) "
			+ "values ('"+usuario.getUsuario()+"','"+usuario.getNusuario()+"','"+usuario.getAusuario()+"','"+ MD5.crypt(usuario.getClave())+"','"+usuario.getNacimiento()+"',1,'"+usuario.getDni()+"','"+usuario.getDireccion()+"','"+usuario.getTelefono()+"')");

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
	public UsuarioBean obtenerid(String Usuario) {
		UsuarioBean usuario=null;
		try {
			Connection conexion = DAO.obtenerConexion();
			Statement stmt = conexion.createStatement();
			
			ResultSet rs =
					stmt.executeQuery("select * from usuario where usuario='"+Usuario+"'");
			
			if( rs.next() ){
				usuario = new UsuarioBean();
				usuario.setId( rs.getInt("id") );
				usuario.setUsuario( rs.getString("usuario") );
				usuario.setNusuario( rs.getString("nusuario") );
				usuario.setAusuario( rs.getString("ausuario") );
				usuario.setClave(rs.getString("clave"));
				usuario.setNacimiento(rs.getInt("nacimiento"));
				usuario.setTipo(rs.getInt("tipo"));
				usuario.setDni(rs.getInt("dni"));
				usuario.setDireccion(rs.getString("direccion"));
				usuario.setTelefono(rs.getInt("telefono"));
				
				
			}
		
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		
		return usuario;
	}

}
