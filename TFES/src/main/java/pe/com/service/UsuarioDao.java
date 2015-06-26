package pe.com.service;

import java.util.List;

import pe.com.modelo.Usuario;

public interface UsuarioDao {
	
	public boolean agregar(Usuario usuario);
	
	public List<Usuario> listar();

}
