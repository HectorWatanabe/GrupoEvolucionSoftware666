package pe.com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import pe.com.modelo.Pedido;

public class PedidoDaoImpl implements PedidoDao{
	private JdbcTemplate jdbcTemp;
	public void setJdbcTemp(JdbcTemplate jdbcTemp) {
		this.jdbcTemp = jdbcTemp;
	}
	@Override
	public List<Pedido> listar() {
		
		return jdbcTemp.query("select * from pedido", new ResultSetExtractor<List<Pedido>>(){
			public List<Pedido> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		Pedido pedido = null;
		while(rs.next()){
			pedido = new Pedido();
			pedido.setId(rs.getInt("id"));
			pedido.setUsuario_id(rs.getInt("usuario_id"));
			pedido.setEstado(rs.getInt("estado"));
			pedidos.add(pedido);
		}
		return pedidos;
	}
});
		
	}
	@Override
	public boolean cambiarestado(String id) {
		Pedido pedido = obtenerPedido(id);
		boolean flag = false;
		int filas=0;
		
			if(pedido.getEstado()==1)
			{
			 filas =  jdbcTemp.update("update pedido "
					+ " set estado=2"
					+ " where id=" +id );
			}
			else
			{if(pedido.getEstado()==2){
			 filas =  jdbcTemp.update("update pedido "
						+ " set estado=1"
						+ " where id=" +id );}
			}

			
			
			if(filas==1){
				flag = true;
			}
		
		return flag;
	}
	@Override
	public Pedido obtenerPedido(String id) {
		return jdbcTemp.query("select * from pedido where id='"+id+"'", new ResultSetExtractor<Pedido>(){
			public Pedido extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				
				Pedido pedido = null;
				while(rs.next()){
					pedido = new Pedido();
					pedido.setId(rs.getInt("id"));
					pedido.setUsuario_id(rs.getInt("usuario_id"));
					pedido.setEstado(rs.getInt("estado"));				
				}
				return pedido;
			}
		});
	}
	
}
