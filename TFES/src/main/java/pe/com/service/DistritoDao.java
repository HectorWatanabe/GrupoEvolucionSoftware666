package pe.com.service;

import java.util.List;

import pe.com.modelo.Distrito;


public interface DistritoDao {
	
	public boolean agregar(Distrito distrito);
	
	public List<Distrito> listar();

}
