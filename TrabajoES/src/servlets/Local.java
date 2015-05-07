package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.LocalBean;
import dao.DAO;
import dao.LocalDao;

/**
 * Servlet implementation class Local
 */
@WebServlet("/Local")
public class Local extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Local() {
        super();

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
			
			LocalDao localdao=DAO.getLocalDao();
			Vector<LocalBean> locales= localdao.listarTodos();
			request.setAttribute("locales", locales);
			
			
			
			
			getServletContext().getRequestDispatcher("/Admin/locales_listar.jsp?numero=1").forward(request, response);
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
		try {
			String nlocal = request.getParameter("nlocal");
			String direccion = request.getParameter("direccion");
			String telefono = request.getParameter("telefono");
			String correo =request.getParameter("correo");
			String distrito =request.getParameter("distrito");
			
			LocalBean local = new LocalBean();
			local.setNlocal(nlocal);
			local.setDireccion(direccion);
			local.setTelefono(Integer.parseInt(telefono));
			local.setCorreo( correo );
			local.setDistrito(distrito);
			LocalDao localdao = DAO.getLocalDao();
			boolean flag = localdao.insertar(local);
			
			if(flag){
				request.setAttribute("mensaje", "Datos guardados correctamente");
			}else{
				request.setAttribute("mensaje", "Ocurrió un error");
			}
			
			getServletContext().getRequestDispatcher("/Admin/locales_insertar.jsp?numero=1").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
	}

}
