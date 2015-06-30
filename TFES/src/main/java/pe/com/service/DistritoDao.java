package pe.com.service;

import java.util.List;

import pe.com.modelo.Distrito;
import pe.com.modelo.Local;


public interface DistritoDao {
	
	public boolean agregar(Distrito distrito);
	
	public List<Distrito> listar();
	public boolean borrar(String id);
	public Distrito obtenerid(String id);
	public boolean editar(Distrito distrito);
	public Distrito obtenerdistrito(String ndistrito);
	public List<Local> listar2(String id);

}
