package pe.com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import pe.com.modelo.Distrito;
import pe.com.modelo.Local;

public class DistritoDaoImpl implements DistritoDao{

	
	private JdbcTemplate jdbcTemp;
	public void setJdbcTemp(JdbcTemplate jdbcTemp) {
		this.jdbcTemp = jdbcTemp;
	}
	
	@Override
	public List<Local> listar2(String id) {
		
		return jdbcTemp.query("select * from local where distrito='"+id+"' ", new ResultSetExtractor<List<Local>>(){
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
	}
	
	@Override
	public boolean agregar(Distrito distrito) {

		boolean flag = false;
		Distrito distr=null;
		distr=obtenerdistrito(distrito.getNdistrito());
		int filas=0;
		
		if(distr==null){
		filas = jdbcTemp.update("insert into distrito (ndistrito) " +
				"values('"+distrito.getNdistrito()+"')");
		}
		if(filas == 1){
			flag = true;
		}
		
		return flag;
	}

	@Override
	public List<Distrito> listar() {
		
		return jdbcTemp.query("select * from distrito", new ResultSetExtractor<List<Distrito>>(){
			public List<Distrito> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<Distrito> distritos = new ArrayList<Distrito>();
		Distrito distrito = null;
		while(rs.next()){
			distrito = new Distrito();
			distrito.setId(rs.getInt("id"));
			distrito.setNdistrito(rs.getString("ndistrito"));
			distritos.add(distrito);
		}
		return distritos;
	}
});
	}

	@Override
	public boolean borrar(String id) {
		boolean flag=false;
		int filas=0;
		List<Local> loc=null;
		loc= listar2(id);
		
		if(loc.size()==0){
		filas = jdbcTemp.update("delete from distrito where id=" + id);
		}
		
		if(filas==1){
			flag = true;
		}
	return flag;
	}

	@Override
	public Distrito obtenerid(String id) {
		return jdbcTemp.query("select * from distrito where id='"+id+"'", new ResultSetExtractor<Distrito>(){
			public Distrito extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				
				Distrito distrito = null;
				while(rs.next()){
					distrito = new Distrito();
					distrito.setId(rs.getInt("id"));
					distrito.setNdistrito(rs.getString("ndistrito"));
				}
				return distrito;
			}
		});
	}

	@Override
	public boolean editar(Distrito distrito) {
		boolean flag = false;
		Distrito distr=null;
		distr=obtenerdistrito(distrito.getNdistrito());
		int filas=0;
		
		if(distr==null|| distr.getId()==distrito.getId()){
		 filas = jdbcTemp.update("update distrito "
				+ " set ndistrito='" + distrito.getNdistrito() + "'"
				+ " where id=" + distrito.getId() );
		}
		
		if(filas==1){
			flag = true;
		}

	return flag;
	}
	
	@Override
	public Distrito obtenerdistrito(String ndistrito) {
		return jdbcTemp.query("select * from distrito where ndistrito='"+ndistrito+"'", new ResultSetExtractor<Distrito>(){
			public Distrito extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				
				Distrito distrito = null;
				while(rs.next()){
					distrito = new Distrito();
					distrito.setId(rs.getInt("id"));
					distrito.setNdistrito(rs.getString("ndistrito"));
				}
				return distrito;
			}
		});
	}

	
}
