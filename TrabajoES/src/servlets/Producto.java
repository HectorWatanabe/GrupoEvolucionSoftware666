package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ProductoBean;
import dao.DAO;
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				request.setAttribute("mensaje", "Ocurri� un error");
			}
			
			getServletContext().getRequestDispatcher("/Admin/productos_insertar.jsp?numero=1").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
	}

}
