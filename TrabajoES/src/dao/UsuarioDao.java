package dao;

import beans.UsuarioBean;

public interface UsuarioDao {
	public boolean ingresar(String usuario,String clave);
	public boolean insertar(UsuarioBean usuario);
	public UsuarioBean obtenerid(String Usuario);
}
