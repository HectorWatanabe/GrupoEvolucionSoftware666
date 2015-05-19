package servlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CategorieBean;
import beans.UsuarioBean;
import dao.CategoriaDao;
import dao.DAO;
import dao.UsuarioDao;
import util.MD5;

/**
 * Servlet implementation class Usuario
 */
@WebServlet("/Usuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		
		getServletContext().getRequestDispatcher("/Admin/usuario_insertar.jsp?numero=2").forward(request, response);
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
			String usuario = request.getParameter("usuario");
			//System.out.print(usuario.matches("[a-zA-Z]+"));
			
			String clave = request.getParameter("clave");
			//System.out.print(clave.matches("[A-Za-z0-9]+"));
			
			if(!usuario.matches("[a-zA-Z]+") || !clave.matches("[A-Za-z0-9]+")){
				request.setAttribute("mensaje", "Datos incorrectos");
				getServletContext().getRequestDispatcher("/Admin/usuario_insertar.jsp?numero=2").forward(request, response);
			}else{
			
				UsuarioDao usuariodao=DAO.getUsuarioDao();
				boolean flag= usuariodao.ingresar(usuario, clave);
				UsuarioBean datosU=usuariodao.obtenerid(usuario);
				
				if(flag){
					HttpSession sesion = request.getSession();
					sesion.setAttribute("nombre", datosU.getNusuario() );
					if(datosU.isTipo()==1){
					getServletContext().getRequestDispatcher("/Admin/principalUsuarios.jsp").forward(request, response);
					}else{if(datosU.isTipo()==2){
						getServletContext().getRequestDispatcher("/Admin/principalAdmin.jsp").forward(request, response);}
					else
					{	getServletContext().getRequestDispatcher("/Admin/principalCocina.jsp").forward(request, response);}
					}
						
				
				}else{
					request.setAttribute("mensaje", "Datos incorrectos2");
					getServletContext().getRequestDispatcher("/Admin/usuario_insertar.jsp?numero=2").forward(request, response);
				}
				
				
			
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		break;
		case 2:
			try {
				String usuario = request.getParameter("usuario");
				String nusuario = request.getParameter("nusuario");
				String ausuario = request.getParameter("ausuario");
				String clave = request.getParameter("clave");
				String nacimiento = request.getParameter("nacimiento");
				String direccion = request.getParameter("direccion");
				String dni = request.getParameter("dni");
				String telefono = request.getParameter("telefono");
				UsuarioBean Usuario = new UsuarioBean();
				Usuario.setUsuario(usuario);
				Usuario.setNusuario(nusuario);
				Usuario.setAusuario(ausuario);
				Usuario.setClave(clave);
				Usuario.setDni(Integer.parseInt(dni));
				Usuario.setDireccion(direccion);
				Usuario.setTelefono(Integer.parseInt(telefono));
				Usuario.setNacimiento(Integer.parseInt(nacimiento));
				UsuarioDao usuariodao = DAO.getUsuarioDao();
				boolean flag = usuariodao.insertar(Usuario);
				
				if(flag){
					request.setAttribute("mensaje", "Datos guardados correctamente");
				}else{
					request.setAttribute("mensaje", "Ocurrió un error");
				}
				
				getServletContext().getRequestDispatcher("/Admin/usuario_insertar.jsp?numero=1").forward(request, response);
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.print(e.getMessage());
			}
			break;
		}
	}

}
