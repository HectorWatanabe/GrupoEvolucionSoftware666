package pe.com.service;

import java.util.List;

import pe.com.modelo.Pedido;

public interface PedidoDao {
	public List<Pedido> listar();
	public boolean cambiarestado(String id);
	public Pedido obtenerPedido(String id);
}
