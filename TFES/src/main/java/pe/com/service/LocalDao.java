package pe.com.service;

import java.util.List;

import pe.com.modelo.Local;


public interface LocalDao {
	
	public boolean agregar(Local local);
	
	public List<Local> listar();
	public boolean borrar(String id);
	public Local obtenerid(String id);
	public boolean editar(Local local);
	public Local obtenerlocal(String nlocal);

}
