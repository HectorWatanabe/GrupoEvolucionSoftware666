package servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import beans.CategorieBean;
import beans.DistritoBean;
import beans.LocalBean;
import beans.ProductoBean;
import dao.CategoriaDao;
import dao.DAO;
import dao.DistritoDao;
import dao.LocalDao;
import dao.ProductoDao;

/**
 * Servlet implementation class Producto
 */
@WebServlet("/Producto")
public class Producto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Producto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int metodo = Integer.parseInt(request.getParameter("metodo"));
		switch(metodo)
		{
		case 1:
		try
		{
		
		CategoriaDao categoriadao=DAO.getCategoriaDao();
		Vector<CategorieBean> categorias= categoriadao.listarTodos();
		request.setAttribute("categorias", categorias);
		
		
		
		
		getServletContext().getRequestDispatcher("/Admin/productos_insertar.jsp?numero=1").forward(request, response);
		}catch(Exception e)
		{
		System.out.print(e.getMessage());
		}
			break;
		
		case 2:
			try
			{
			
			ProductoDao productodao=DAO.getProductoDao();
			Vector<ProductoBean> productos= productodao.listarTodos();
			request.setAttribute("productos", productos);
			int opcion = Integer.parseInt(request.getParameter("opcion"));
						
			
			switch(opcion)
			{
			case 1:
			getServletContext().getRequestDispatcher("/Admin/locales_listar.jsp?numero=2").forward(request, response);
			break;
			case 2:
			getServletContext().getRequestDispatcher("/Admin/listas_vistaU.jsp?numero=2").forward(request, response);
			break;
			case 3:
			getServletContext().getRequestDispatcher("/Admin/vista_general.jsp?numero=2").forward(request, response);
			break;
			}
			}catch(Exception e)
			{
			System.out.print(e.getMessage());
			}
			break;
			
		case 3:
			try
			{
			String dato = request.getParameter("codigo");
			ProductoDao ProductoDao=DAO.getProductoDao();
			ProductoBean producto= ProductoDao.obtenerid(dato);
			CategoriaDao categoriadao=DAO.getCategoriaDao();
			Vector<CategorieBean> categorias= categoriadao.listarTodos();
			request.setAttribute("categorias", categorias);
			request.setAttribute("producto", producto);
			getServletContext().getRequestDispatcher("/Admin/productos_insertar.jsp?numero=2").forward(request, response);
			
			
			}catch(Exception e)
			{
			System.out.print(e.getMessage());
			}
			
			break;
		case 4:
			try
			{
				String dato = request.getParameter("codigo");
			ProductoDao productodao=DAO.getProductoDao();
			boolean flag= productodao.borrar(dato);
			if(flag){
				request.setAttribute("mensaje", "Datos borrados correctamente");
			}else{
				request.setAttribute("mensaje", "Ocurrió un error");
			}
			
			
			
			
			getServletContext().getRequestDispatcher("/Producto?metodo=2&opcion=1").forward(request, response);
			}catch(Exception e)
			{
			System.out.print(e.getMessage());
			}
			break;
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int metodo = Integer.parseInt(request.getParameter("metodo"));
		switch(metodo)
		{
		case 1:
		try {
			String nproducto = request.getParameter("nproducto");
			String descripcion = request.getParameter("descripcion");
			String categoria_id = request.getParameter("categoria_id");
			String precio =request.getParameter("precio");
			
			ProductoBean producto = new ProductoBean();
			producto.setNproducto(nproducto);
			producto.setDescripcion(descripcion);
			producto.setCategoria_id(Integer.parseInt(categoria_id));
			producto.setPrecio( Float.parseFloat(precio) );
			
			ProductoDao productodao = DAO.getProductoDao();
			boolean flag = productodao.insertar(producto);
			
			if(flag){
				request.setAttribute("mensaje", "Datos guardados correctamente");
			}else{
				request.setAttribute("mensaje", "Ocurrió un error");
			}
			
			getServletContext().getRequestDispatcher("/Admin/productos_insertar.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		break;
		
		case 2:
			try {
				
				ProductoBean producto = new ProductoBean();
				producto.setId(Integer.parseInt( request.getParameter("id")));
				producto.setNproducto(request.getParameter("nproducto"));
				producto.setDescripcion(request.getParameter("descripcion"));
				producto.setCategoria_id(Integer.parseInt(request.getParameter("categoria_id")));
				producto.setPrecio(Float.parseFloat(request.getParameter("precio")));
				ProductoDao productodao = DAO.getProductoDao();
				boolean flag = productodao.editar(producto);
				
				if(flag){
					request.setAttribute("mensaje", "Datos guardados correctamente");
				}else{
					request.setAttribute("mensaje", "Ocurrió un error");
				}
				
				getServletContext().getRequestDispatcher("/Admin/productos_insertar.jsp").forward(request, response);
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.print(e.getMessage());
			}
			break;
		
		}
	}

}


/////////////////////////////////////////////////////////////////////////////
