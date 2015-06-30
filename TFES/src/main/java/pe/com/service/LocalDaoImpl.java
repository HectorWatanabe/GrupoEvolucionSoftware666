package pe.com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import pe.com.modelo.Local;

public class LocalDaoImpl implements LocalDao{
	
	private JdbcTemplate jdbcTemp;
	public void setJdbcTemp(JdbcTemplate jdbcTemp) {
		this.jdbcTemp = jdbcTemp;
	}
	
	@Override
	public boolean agregar(Local local) {
		
		boolean flag = false;
		Local loc=null;
		loc=obtenerlocal(local.getNlocal());
		
		int filas=0;
		if(loc==null){
		filas = jdbcTemp.update("insert into local (nlocal,direccion,telefono,correo,distrito) " +
				"values('"+local.getNlocal()+"','"+local.getDireccion()+"','"+local.getTelefono()+"','"+local.getCorreo()+"','"+local.getDistrito()+"')");
		}
		if(filas == 1){
			flag = true;
		}
		
		return flag;
	}

	@Override
	public List<Local> listar() {

		List<Local> locales = new ArrayList<Local>();
		locales= jdbcTemp.query("select * from local", new ResultSetExtractor<List<Local>>(){
			public List<Local> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<Local> locales = new ArrayList<Local>();
		Local local = null;
		while(rs.next()){
			local = new Local();
			local.setId(rs.getInt("id"));
			local.setNlocal(rs.getString("nlocal"));
			local.setDireccion(rs.getString("direccion"));
			local.setTelefono(rs.getString("telefono"));
			local.setCorreo(rs.getString("correo"));
			local.setDistrito(rs.getInt("distrito"));
			locales.add(local);
		}
		return locales;
	}
});
		return locales;
	}

	@Override
	public boolean borrar(String id) {
		boolean flag=false;
		
		
		int filas = jdbcTemp.update("delete from local where id=" + id);
		
		
		if(filas==1){
			flag = true;
		}
	return flag;
	}

	@Override
	public Local obtenerid(String id) {
		return jdbcTemp.query("select * from local where id='"+id+"'", new ResultSetExtractor<Local>(){
			public Local extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				
				Local local = null;
				while(rs.next()){
					local = new Local();
					local.setId(rs.getInt("id"));
					local.setNlocal(rs.getString("nlocal"));
					local.setDireccion(rs.getString("direccion"));
					local.setTelefono(rs.getString("telefono"));
					local.setCorreo(rs.getString("correo"));
					local.setDistrito(rs.getInt("distrito"));
					
				}
				return local;
			}
		});
	}

	@Override
	public boolean editar(Local local) {
		boolean flag = false;
		Local loc=null;
		loc=obtenerlocal(local.getNlocal());
		
		int filas=0;
		if(loc==null){
		filas = jdbcTemp.update("update local "
				+ " set nlocal='" + local.getNlocal() + "',"
				+ " direccion='" + local.getDireccion() + "',"
				+ " correo='" + local.getCorreo() + "',"
				+ " telefono='" + local.getTelefono() + "',"
				+ " distrito='" + local.getDistrito() + "'"
				+ " where id=" + local.getId() );
		}
		
		if(filas==1){
			flag = true;
		}

	return flag;
	}
	@Override
	public Local obtenerlocal(String nlocal) {
		return jdbcTemp.query("select * from local where nlocal='"+nlocal+"'", new ResultSetExtractor<Local>(){
			public Local extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				
				Local local = null;
				while(rs.next()){
					local = new Local();
					local.setId(rs.getInt("id"));
					local.setNlocal(rs.getString("nlocal"));
					local.setDireccion(rs.getString("direccion"));
					local.setTelefono(rs.getString("telefono"));
					local.setCorreo(rs.getString("correo"));
					local.setDistrito(rs.getInt("distrito"));
					
				}
				return local;
			}
		});
	}
}
