package pe.com.empresa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.com.modelo.Usuario;
import pe.com.service.UsuarioDao;
import pe.com.service.UsuarioDaoImpl;
import pe.com.util.Fecha;
@Controller
public class UsuarioController {
	
	@RequestMapping(value="/inicio/usuario/listado", method= RequestMethod.GET)
	public String listar(Model model){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		UsuarioDao usuariodao = (UsuarioDaoImpl)context.getBean("iUsuarioImpl");
		
		List<Usuario> usuarios = usuariodao.listar();
		model.addAttribute("usuarios", usuarios);
		
		return "/inicio/usuario/listar";
	}
	
	@RequestMapping(value="/inicio/usuario", method= RequestMethod.GET)
	public ModelAndView usuario(){
		
		return new ModelAndView("inicio/usuario/agregar", "command", new Usuario());
	}
	
	@RequestMapping(value="/inicio/login", method= RequestMethod.GET)
	public ModelAndView login( HttpServletRequest request){
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return new ModelAndView("inicio/Home1", "command", new Usuario());
			}
		if(user.getTipo()==2)
		{
		return new ModelAndView("inicio/homeadmin", "command", new Usuario());
		}
		if(user.getTipo()==3)
		{
		return new ModelAndView("inicio/homecocinero", "command", new Usuario());
		}
		}
		return new ModelAndView("inicio/login", "command", new Usuario());
		
	}
	
	@RequestMapping(value="/inicio/login", method= RequestMethod.POST)
	public ModelAndView inicioHome(String usuario, String clave, Model model, HttpServletRequest request){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		UsuarioDao usuariodao = (UsuarioDaoImpl)context.getBean("iUsuarioImpl");
		Usuario flag = usuariodao.ingresar(usuario, clave);
		
		
		if(flag!=null){
			HttpSession misession= request.getSession();
			misession.setAttribute("usuario", flag);
			if(flag.getTipo()==1){
				
				model.addAttribute("mensaje", "Bienvenido");
				model.addAttribute("usuario", flag.getAusuario());
				return new ModelAndView("inicio/homeuser", "command", new Usuario());
			}else{if(flag.getTipo()==2){
				model.addAttribute("mensaje", "Bienvenido");
				model.addAttribute("admin", flag.getAusuario());
				return new ModelAndView("inicio/homeadmin", "command", new Usuario());}
			else
			{	
				model.addAttribute("mensaje", "Bienvenido");
			return new ModelAndView("inicio/homecocinero", "command", new Usuario());}
			}
				
		
		}else{
			model.addAttribute("mensaje", "Usuario o Contraseña incorrecta");
			return new ModelAndView("inicio/login", "command", new Usuario());
		}
		
		
		
	}
	
	@RequestMapping(value="/inicio/usuario", method= RequestMethod.POST)
	public ModelAndView usuario(Usuario usuario, Model model,HttpServletRequest request){
		boolean flag=false;
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		UsuarioDao usuariodao = (UsuarioDaoImpl)context.getBean("iUsuarioImpl"); 
		
		if(!usuario.getClave().matches("(?!^[0-9]*$)(?=.*[A-Z])(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{6,15})$"))
		{
			model.addAttribute("mensaje", "La contraseña debe tener entre 6-15 caracteres, un numero y una mayuscula");
			
		}else
		{
			Fecha fecha= new Fecha();
			if(!fecha.validate(usuario.getNacimiento()))
			{
				model.addAttribute("mensaje", "La Fecha de nacimiento debe ser en formato dd/mm/aaaa" );}
			else{
				if(!usuario.getNusuario().matches("[a-zA-Z]+")||!usuario.getAusuario().matches("[a-zA-Z]+"))
				{
					model.addAttribute("mensaje", "Los nombre y apellidos no deben tener numeros ni caracteres especiales o estar en blanco");
				}else
				{
					if(!usuario.getDni().matches("[0-9]{8}+")||!usuario.getTelefono().matches("[0-9]{7,9}+"))
					{
						model.addAttribute("mensaje", "EL DNI y telefono deben ser numeros validos");
					}else{
						if(!usuario.getUsuario().matches("[A-Za-z0-9]+")||usuario.getUsuario()=="")
						{
							model.addAttribute("mensaje", "No se permiten caracteres especiales o campo vacio");
						}
						else{
							flag = usuariodao.agregar(usuario);
							if(flag){
								model.addAttribute("mensaje", "Usuario guardado");
							}
							else{model.addAttribute("mensaje", "Ocurrio un Error");}}}}
		
		}
		}
		
		
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return new ModelAndView("inicio/login", "command", null);
			}
		if(user.getTipo()==2)
		{
			return new ModelAndView("inicio/login", "command", null);
		}
		}
		return new ModelAndView("/inicio/usuario/agregar", "command", new Usuario());
		
		
	}
	
	@RequestMapping(value="/inicio/login/cerrarsesion", method= RequestMethod.GET)
	public ModelAndView cerrarsession(Model model, HttpServletRequest request){
		request.getSession().invalidate();

		return new ModelAndView("inicio/Home", "command", new Usuario());
	}
	
	@RequestMapping(value="/inicio/nosotros1", method= RequestMethod.GET)
	public String nosotros(Model model, HttpServletRequest request){
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return "/inicio/Home1";
			}
		if(user.getTipo()==3)
		{
		return "/inicio/Home2";
		}
		}
			return "/inicio/Home";
		

		
	}
	
	
	
	@RequestMapping(value="/inicio/usuario/datos", method= RequestMethod.GET)
	public String datosUser(Model model, HttpServletRequest request){
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return "/inicio/usuario/datouser";
			}
		if(user.getTipo()==2)
		{
		return "/inicio/usuario/datoadmin";
		}
		if(user.getTipo()==3)
		{
		return "/inicio/usuario/datococinero";
		}
		}
			return "/inicio/Home";
		

		
	}
	
	@RequestMapping(value="/inicio/usuario/borrar", method= RequestMethod.GET)
	public String borrar( Model model,HttpServletRequest request){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		UsuarioDao usuariodao = (UsuarioDaoImpl)context.getBean("iUsuarioImpl");
		
		
		String id =(String)request.getParameter("id");
		boolean flag = usuariodao.borrar(id);
		Usuario userID= usuariodao.obtenerUser(id);
		List<Usuario> usuarios = usuariodao.listar();
		model.addAttribute("usuarios", usuarios);
		if(flag){
			if(userID.getEstado()==2)
			{
			model.addAttribute("mensaje", "El Usuario ahora esta Inactivo");
			}else
			{
				if(userID.getEstado()==1)
				model.addAttribute("mensaje", "El Usuario ahora esta Activo");	
			}
		}else{
			model.addAttribute("mensaje", "Ocurrió un error");
		}
		
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return "inicio/homeuser";
			}
		if(user.getTipo()==2)
		{
		return "inicio/usuario/listar";
		}
		}
			return "/inicio/Home";
	}
	

}
