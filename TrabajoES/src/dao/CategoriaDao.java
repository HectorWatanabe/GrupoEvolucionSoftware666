package dao;

import java.util.Vector;

import beans.CategorieBean;



public interface CategoriaDao {

	public boolean insertar(CategorieBean categoria);
	public Vector<CategorieBean> listarTodos();
	public boolean borrar(String id);
	public CategorieBean obtenerid(String id);
	public boolean editar(CategorieBean categoria);
}
