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
		
		int filas = jdbcTemp.update("insert into local (nlocal,direccion,telefono,correo,distrito) " +
				"values('"+local.getNlocal()+"','"+local.getDireccion()+"','"+local.getTelefono()+"','"+local.getCorreo()+"','"+local.getDistrito()+"')");
		
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
			local.setTelefono(rs.getInt("telefono"));
			local.setCorreo(rs.getString("correo"));
			local.setDistrito(rs.getInt("distrito"));
			locales.add(local);
		}
		return locales;
	}
});
		return locales;
	}

}
