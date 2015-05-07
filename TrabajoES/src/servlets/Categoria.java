package servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CategorieBean;
import dao.CategoriaDao;
import dao.DAO;

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
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
