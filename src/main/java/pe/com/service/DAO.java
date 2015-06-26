package pe.com.service;

public class DAO {
	
	public static ProductoDao getProductoDao(){
		return new ProductoDaoImpl();
	}
	public static LocalDao getLocalDao()
	{
		return new LocalDaoImpl();
	}
	public static CategoriaDao getCategoriaDao()
	{
		return new CategoriaDaoImpl();
	}
	public static DistritoDao getDistritoDao()
	{
		return new DistritoDaoImpl();
	}
	public static UsuarioDao getUsuarioDao()
	{
		return new UsuarioDaoImpl();
	}

}
