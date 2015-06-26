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
	public boolean agregar(Usuario usuario) {
		
		boolean flag = false;
		
		int filas = jdbcTemp.update("insert into usuario (usuario,nusuario,ausuario,clave,nacimiento,tipo,dni,direccion,telefono) " +
				"values('"+usuario.getUsuario()+"','"+usuario.getNusuario()+"','"+usuario.getAusuario()+"','"+ MD5.crypt(usuario.getClave())+"',"
						+ "'"+usuario.getNacimiento()+"','1','"+usuario.getDni()+"','"+usuario.getDireccion()+"','"+usuario.getTelefono()+"')");
		
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
					usuario.setNacimiento(rs.getInt("nacimiento"));
					usuario.setTipo(rs.getInt("tipo"));
					usuario.setDni(rs.getInt("dni"));
					usuario.setDireccion(rs.getString("direccion"));
					usuario.setTelefono(rs.getInt("telefono"));
					usuarios.add(usuario);
				}
				return usuarios;
			}
		});
	}

}
