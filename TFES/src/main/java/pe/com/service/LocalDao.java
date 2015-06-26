package pe.com.service;

import java.util.List;

import pe.com.modelo.Local;


public interface LocalDao {
	
	public boolean agregar(Local local);
	
	public List<Local> listar();

}
