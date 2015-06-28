package pe.com.service;

import java.util.List;

import pe.com.modelo.Usuario;

public interface UsuarioDao {
	public Usuario ingresar(String usuario, String clave);
	
	public boolean agregar(Usuario usuario);
	
	public List<Usuario> listar();
	public Usuario obtenerid(String Usuario);

}
