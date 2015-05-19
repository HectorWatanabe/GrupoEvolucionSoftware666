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
import dao.CategoriaDao;
import dao.DAO;
import dao.DistritoDao;

/**
 * Servlet implementation class Distrito
 */
@WebServlet("/Distrito")
public class Distrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Distrito() {
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
		
		DistritoDao distritodao=DAO.getDistritoDao();
		Vector<DistritoBean> distritos= distritodao.listarTodos();
		request.setAttribute("distritos", distritos);
		
		
		
		
		getServletContext().getRequestDispatcher("/Admin/locales_insertar.jsp?numero=1").forward(request, response);
		}catch(Exception e)
		{
		System.out.print(e.getMessage());
		}
		break;
		
		case 2:
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

}
