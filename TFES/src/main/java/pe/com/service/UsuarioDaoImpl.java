package pe.com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import pe.com.modelo.Usuario;
import pe.com.util.MD5;

public class UsuarioDaoImpl implements UsuarioDao{
private JdbcTemplate jdbcTemp;
	
	public void setJdbcTemp(JdbcTemplate jdbcTemp) {
		this.jdbcTemp = jdbcTemp;
	}
	@Override
	public Usuario ingresar(String usuario, String clave) {
	
		if(clave=="" || usuario=="")
		{
			return null;
		}
		else{
		return jdbcTemp.query("select * from usuario "
				+ " where usuario='"+usuario+"' and clave='"+ MD5.crypt(clave)+"'", new ResultSetExtractor<Usuario>(){
			public Usuario extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				Usuario usuario = null;
				while(rs.next()){
					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setUsuario(rs.getString("usuario"));
					usuario.setNusuario(rs.getString("nusuario"));
					usuario.setAusuario(rs.getString("ausuario"));
					usuario.setClave(rs.getString("clave"));
					usuario.setNacimiento(rs.getString("nacimiento"));
					usuario.setTipo(rs.getInt("tipo"));
					usuario.setDni(rs.getString("dni"));
					usuario.setDireccion(rs.getString("direccion"));
					usuario.setTelefono(rs.getString("telefono"));
					usuario.setEstado(rs.getInt("estado"));
				}
				return usuario;
			}
		});}
		
	
	}
	@Override
	public boolean agregar(Usuario usuario) {
		
		boolean flag = false;
		
		int filas = jdbcTemp.update("insert into usuario (usuario,nusuario,ausuario,clave,nacimiento,tipo,dni,direccion,telefono,estado) " +
				"values('"+usuario.getUsuario()+"','"+usuario.getNusuario()+"','"+usuario.getAusuario()+"','"+ MD5.crypt(usuario.getClave())+"',"
						+ "'"+usuario.getNacimiento()+"','1','"+usuario.getDni()+"','"+usuario.getDireccion()+"','"+usuario.getTelefono()+"','1')");
		
		if(filas == 1){
			flag = true;
		}
		
		return flag;
	}

	@Override
	public List<Usuario> listar() {
		
		return jdbcTemp.query("select * from usuario", new ResultSetExtractor<List<Usuario>>(){
			public List<Usuario> extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				List<Usuario> usuarios = new ArrayList<Usuario>();
				Usuario usuario = null;
				while(rs.next()){
					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setUsuario(rs.getString("usuario"));
					usuario.setNusuario(rs.getString("nusuario"));
					usuario.setAusuario(rs.getString("ausuario"));
					usuario.setClave(rs.getString("clave"));
					usuario.setNacimiento(rs.getString("nacimiento"));
					usuario.setTipo(rs.getInt("tipo"));
					usuario.setDni(rs.getString("dni"));
					usuario.setDireccion(rs.getString("direccion"));
					usuario.setTelefono(rs.getString("telefono"));
					usuario.setEstado(rs.getInt("estado"));
					usuarios.add(usuario);
				}
				return usuarios;
			}
		});
	}
	
	@Override
	public Usuario obtenerid(String Usuario) {
		
		
		return jdbcTemp.query("select * from usuario where usuario='"+Usuario+"'", new ResultSetExtractor<Usuario>(){
			public Usuario extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				
				Usuario usuario = null;
				while(rs.next()){
					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setUsuario(rs.getString("usuario"));
					usuario.setNusuario(rs.getString("nusuario"));
					usuario.setAusuario(rs.getString("ausuario"));
					usuario.setClave(rs.getString("clave"));
					usuario.setNacimiento(rs.getString("nacimiento"));
					usuario.setTipo(rs.getInt("tipo"));
					usuario.setDni(rs.getString("dni"));
					usuario.setDireccion(rs.getString("direccion"));
					usuario.setTelefono(rs.getString("telefono"));
					usuario.setEstado(rs.getInt("estado"));
				}
				return usuario;
			}
		});
		
				
				
	}
public Usuario obtenerUser(String id) {
		
		
		return jdbcTemp.query("select * from usuario where id='"+id+"'", new ResultSetExtractor<Usuario>(){
			public Usuario extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				
				Usuario usuario = null;
				while(rs.next()){
					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setUsuario(rs.getString("usuario"));
					usuario.setNusuario(rs.getString("nusuario"));
					usuario.setAusuario(rs.getString("ausuario"));
					usuario.setClave(rs.getString("clave"));
					usuario.setNacimiento(rs.getString("nacimiento"));
					usuario.setTipo(rs.getInt("tipo"));
					usuario.setDni(rs.getString("dni"));
					usuario.setDireccion(rs.getString("direccion"));
					usuario.setTelefono(rs.getString("telefono"));
					usuario.setEstado(rs.getInt("estado"));
				}
				return usuario;
			}
		});
		
				
				
	}
	@Override
	public boolean borrar(String id) {
		
		Usuario user = obtenerUser(id);
		boolean flag = false;
		int filas=0;
		
			if(user.getEstado()==1)
			{
			 filas =  jdbcTemp.update("update usuario "
					+ " set estado=2"
					+ " where id=" +id );
			}
			else
			{if(user.getEstado()==2){
			 filas =  jdbcTemp.update("update usuario "
						+ " set estado=1"
						+ " where id=" +id );}
			}

			
			
			if(filas==1){
				flag = true;
			}
		
		return flag;
	}

}
