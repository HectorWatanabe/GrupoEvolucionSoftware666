package dao;

import java.util.Vector;

import beans.LocalBean;

public interface LocalDao {

	public boolean insertar(LocalBean local);

	public Vector<LocalBean> listarTodos();
	
	public LocalBean buscarPorID(int id);
}
