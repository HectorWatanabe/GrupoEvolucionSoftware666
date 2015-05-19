package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CategorieBean;
import beans.LocalBean;
import dao.CategoriaDao;
import dao.DAO;
import dao.LocalDao;

/**
 * Servlet implementation class Categoria
 */
@WebServlet("/Categoria")
public class Categoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Categoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int metodo = Integer.parseInt(request.getParameter("metodo"));
		switch(metodo)
		{
		case 1:
		
		try
		{
		
		CategoriaDao categoriadao=DAO.getCategoriaDao();
		Vector<CategorieBean> categorias= categoriadao.listarTodos();
		request.setAttribute("categorias", categorias);
		
		
		
		
		getServletContext().getRequestDispatcher("/Admin/locales_listar.jsp?numero=3").forward(request, response);
		}catch(Exception e)
		{
		System.out.print(e.getMessage());
		}
		break;
		
		case 2:
			
			try
			{
				String dato = request.getParameter("codigo");
			CategoriaDao CategoriaDao=DAO.getCategoriaDao();
			boolean flag= CategoriaDao.borrar(dato);
			if(flag){
				request.setAttribute("mensaje", "Datos borrados correctamente");
			}else{
				request.setAttribute("mensaje", "Ocurrió un error");
			}
			
			
			
			
			getServletContext().getRequestDispatcher("/Categoria?metodo=1").forward(request, response);
			}catch(Exception e)
			{
			System.out.print(e.getMessage());
			}
			break;
		
		case 3:
			try
			{
				String dato = request.getParameter("codigo");
			CategoriaDao CategoriaDao=DAO.getCategoriaDao();
			CategorieBean categoria= CategoriaDao.obtenerid(dato);
			
			request.setAttribute("categoria", categoria);
			getServletContext().getRequestDispatcher("/Admin/locales_insertar.jsp?numero=3").forward(request, response);
			
			
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
		// TODO Auto-generated method stub
		int metodo = Integer.parseInt(request.getParameter("metodo"));
		switch(metodo)
		{
		case 1:
		
		try {
			String ncategoria = request.getParameter("ncategoria");
			
			CategorieBean categoria = new CategorieBean();
			categoria.setNcategoria(ncategoria);
			CategoriaDao categoriadao = DAO.getCategoriaDao();
			boolean flag = categoriadao.insertar(categoria);
			
			if(flag){
				request.setAttribute("mensaje", "Datos guardados correctamente");
			}else{
				request.setAttribute("mensaje", "Ocurrió un error");
			}
			
			getServletContext().getRequestDispatcher("/Admin/locales_insertar.jsp?numero2=1").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		break;
		case 2:
			try {
			
				CategorieBean categoria = new CategorieBean();
				categoria.setId(Integer.parseInt( request.getParameter("id")));
				categoria.setNcategoria(request.getParameter("ncategoria"));
				CategoriaDao categoriadao = DAO.getCategoriaDao();
				boolean flag = categoriadao.editar(categoria);
				
				if(flag){
					request.setAttribute("mensaje", "Datos guardados correctamente");
				}else{
					request.setAttribute("mensaje", "Ocurrió un error");
				}
				
				getServletContext().getRequestDispatcher("/Admin/locales_insertar.jsp").forward(request, response);
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.print(e.getMessage());
			}
			break;
		}
		
		
	}

}
