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
	
	@RequestMapping(value="/inicio/usuario/agregar", method= RequestMethod.POST)
	public String usuario(Usuario usuario, Model model,HttpServletRequest request){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		UsuarioDao usuariodao = (UsuarioDaoImpl)context.getBean("iUsuarioImpl");
		
		boolean flag = usuariodao.agregar(usuario);
		
		if(flag){
			model.addAttribute("mensaje", "Usuario guardado");
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
		return "inicio/homeadmin";
		}
		}
			return "/inicio/mensaje1";
		
		
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
	

}
