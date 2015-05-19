package dao;

import java.util.Vector;

import beans.CategorieBean;
import beans.LocalBean;

public interface LocalDao {

	public boolean insertar(LocalBean local);
	public boolean borrar(String id);
	public Vector<LocalBean> listarTodos();
	public LocalBean obtenerid(String id);
	public boolean editar(LocalBean local);
}
