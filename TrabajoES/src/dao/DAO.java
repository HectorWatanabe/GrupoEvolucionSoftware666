package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DAO {

	public static Connection obtenerConexion(){
		Connection conexion = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			Properties prop = new Properties();
			
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream rStream = loader.getResourceAsStream("config.properties");
			
			prop.load(rStream);
			
			
			String url = "jdbc:mysql://"+prop.getProperty("servidor")+":3306/" + prop.getProperty("basedatos");
			conexion = DriverManager.getConnection
									(url, 
										prop.getProperty("usuario") ,
										prop.getProperty("clave")
									);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		
		
		return conexion;
	}
	
	public static ProductoDao getProductoDao(){
		return new ProductoDaoImpl();
}
}
