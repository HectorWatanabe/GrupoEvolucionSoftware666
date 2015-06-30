package pe.com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import pe.com.modelo.Categoria;
import pe.com.modelo.Producto;

public class CategoriaDaoImpl implements CategoriaDao {
private JdbcTemplate jdbcTemp;
	
	public void setJdbcTemp(JdbcTemplate jdbcTemp) {
		this.jdbcTemp = jdbcTemp;
	}
	@Override
	public boolean agregar(Categoria categoria) {
		// TODO Auto-generated method stub
	boolean flag = false;
	Categoria cat=null;
	cat=obtenercat(categoria.getNcategoria());
	int filas=0;
	if(cat==null){
		 filas = jdbcTemp.update("insert into categoria (ncategoria) " +
				"values('"+categoria.getNcategoria()+"')");
	}
		if(filas == 1){
			flag = true;
		}
		
		return flag;
	}
	@Override
	public boolean borrar(String id) {
		
		
		boolean flag=false;
			
			List<Producto> pro =null;
			pro= listar2(id);
			int filas=0;
			
			if(pro.size()==0){
			filas = jdbcTemp.update("delete from categoria where id=" + id);
			}
			
			if(filas==1){
				flag = true;
			}
		return flag;
	}
	@Override
	public List<Categoria> listar() {
		// TODO Auto-generated method stub
		return jdbcTemp.query("select * from categoria", new ResultSetExtractor<List<Categoria>>(){
			public List<Categoria> extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				List<Categoria> categorias = new ArrayList<Categoria>();
				Categoria categoria = null;
				while(rs.next()){
					categoria = new Categoria();
					categoria.setId(rs.getInt("id"));
					categoria.setNcategoria(rs.getString("ncategoria"));
					categorias.add(categoria);
				}
				return categorias;
			}
		});
	}
	@Override
	public boolean editar(Categoria categoria) {
			boolean flag = false;
		
			Categoria cat=null;
			cat=obtenercat(categoria.getNcategoria());
			int filas=0;
			if(cat==null||cat.getId()==categoria.getId()){
			filas = jdbcTemp.update("update categoria "
					+ " set ncategoria='" + categoria.getNcategoria() + "'"
					+ " where id=" + categoria.getId() );
			}
			
			if(filas==1){
				flag = true;
			}
	
		return flag;
	}
	@Override
	public Categoria obtenerid(String id) {
			
		return jdbcTemp.query("select * from categoria where id='"+id+"'", new ResultSetExtractor<Categoria>(){
			public Categoria extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				
				Categoria categoria = null;
				while(rs.next()){
					categoria = new Categoria();
					categoria.setId(rs.getInt("id"));
					categoria.setNcategoria(rs.getString("ncategoria"));
				}
				return categoria;
			}
		});
	}
	
	@Override
	public Categoria obtenercat(String ncategoria) {
			
		return jdbcTemp.query("select * from categoria where ncategoria='"+ncategoria+"'", new ResultSetExtractor<Categoria>(){
			public Categoria extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				
				Categoria categoria = null;
				while(rs.next()){
					categoria = new Categoria();
					categoria.setId(rs.getInt("id"));
					categoria.setNcategoria(rs.getString("ncategoria"));
				}
				return categoria;
			}
		});
	}
	@Override
	public List<Producto> listar2(String id) {
		return jdbcTemp.query("select * from producto where categoria_id='"+id+"'", new ResultSetExtractor<List<Producto>>(){
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
