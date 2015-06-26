package pe.com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import pe.com.modelo.Producto;

public class ProductoDaoImpl implements ProductoDao{

	private JdbcTemplate jdbcTemp;
	public void setJdbcTemp(JdbcTemplate jdbcTemp) {
		this.jdbcTemp = jdbcTemp;
	}
	
	@Override
	public boolean agregar(Producto producto) {

		boolean flag = false;
		
		int filas = jdbcTemp.update("insert into producto (nproducto,descripcion,categoria_id,precio) " +
				"values('"+producto.getNproducto()+"','"+producto.getDescripcion()+"','"+producto.getCategoria_id()+"','"+producto.getPrecio()+"')");
		
		if(filas == 1){
			flag = true;
		}
		
		return flag;
	}

	@Override
	public List<Producto> listar() {
		return jdbcTemp.query("select * from producto", new ResultSetExtractor<List<Producto>>(){
			public List<Producto> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<Producto> productos = new ArrayList<Producto>();
		Producto producto = null;
		while(rs.next()){
			producto = new Producto();
			producto.setId(rs.getInt("id"));
			producto.setNproducto(rs.getString("nproducto"));
			producto.setDescripcion(rs.getString("descripcion"));
			producto.setCategoria_id(rs.getInt("categoria_id"));
			producto.setPrecio(rs.getFloat("precio"));
			productos.add(producto);
		}
		return productos;
	}
});
	}

}
