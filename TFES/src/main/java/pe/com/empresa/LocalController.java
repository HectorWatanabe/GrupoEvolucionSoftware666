package pe.com.empresa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.com.modelo.Distrito;
import pe.com.modelo.Local;
import pe.com.modelo.Usuario;
import pe.com.service.DistritoDao;
import pe.com.service.DistritoDaoImpl;
import pe.com.service.LocalDao;
import pe.com.service.LocalDaoImpl;
@Controller
public class LocalController {
	
	@RequestMapping(value="/inicio/local/listado", method= RequestMethod.GET)
	public String listar(Model model,HttpServletRequest request){
		String tipo =(String)request.getParameter("tipo");
		model.addAttribute("tipo", tipo);
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		LocalDao localdao = (LocalDaoImpl)context.getBean("iLocalImpl");
		DistritoDao distritodao = (DistritoDaoImpl)context.getBean("iDistritoImpl");
		
		List<Local> locales = localdao.listar();
		List<Distrito> distritos = distritodao.listar();
		model.addAttribute("locales", locales);
		model.addAttribute("distritos", distritos);
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return "/inicio/homeuser";
			}
		if(user.getTipo()==2)
		{
			return "/inicio/local/listar";
		}
		}
		return "/inicio/Home";
	}
	@RequestMapping(value="/inicio/local/listado1", method= RequestMethod.GET)
	public String listar1(Model model,HttpServletRequest request){
		String tipo =(String)request.getParameter("tipo");
		model.addAttribute("tipo", tipo);
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		LocalDao localdao = (LocalDaoImpl)context.getBean("iLocalImpl");
		DistritoDao distritodao = (DistritoDaoImpl)context.getBean("iDistritoImpl");
		
		
		
		List<Local> locales = localdao.listar();
		List<Distrito> distritos = distritodao.listar();
		model.addAttribute("locales", locales);
		model.addAttribute("distritos", distritos);
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return "/inicio/local/listar2";
			}
		}
			return "/inicio/local/listar1";
		
	}
	
	
	@RequestMapping(value="/inicio/local", method= RequestMethod.GET)
	public ModelAndView categoria(Model model,HttpServletRequest request){

		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		DistritoDao distritodao = (DistritoDaoImpl)context.getBean("iDistritoImpl");
		
		
		List<Distrito> distritos = distritodao.listar();
		model.addAttribute("distritos", distritos);
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return new ModelAndView("/inicio/homeuser", "command",null);
			}
		if(user.getTipo()==2)
		{
			return new ModelAndView("inicio/local/agregar", "command", new Local());
		}
		}
		return new ModelAndView("/inicio/Home", "command",null);
		
	}
	
	@RequestMapping(value="/inicio/local", method= RequestMethod.POST)
	public ModelAndView local(Local local, Model model,HttpServletRequest request){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		LocalDao localdao = (LocalDaoImpl)context.getBean("iLocalImpl");
		DistritoDao distritodao = (DistritoDaoImpl)context.getBean("iDistritoImpl");
		boolean flag=false;
		if(local.getDireccion()=="" || local.getCorreo()=="")
		{
			model.addAttribute("mensaje", "Campo vacio");
		}else{if(!local.getNlocal().matches("[A-Za-z0-9]+"))
		{
			model.addAttribute("mensaje", "El nombre del local no debe tener caracteres especiales o vacio");
		}else{
			
			if(!local.getTelefono().matches("[0-9]{7,9}+"))
			{
				model.addAttribute("mensaje", "telefono deben ser un numero valido");
			}else{
		flag = localdao.agregar(local);
		
		if(flag){
			model.addAttribute("mensaje", "Local guardado");
		}else{
			model.addAttribute("mensaje", "Ocurrió un error");
		}}}}
		
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return new ModelAndView("/inicio/homeuser", "command",null);
			}if(user.getTipo()==2){
				List<Distrito> distritos = distritodao.listar();
				model.addAttribute("distritos", distritos);
			return new ModelAndView("inicio/local/agregar", "command", new Local());
		}}
		return new ModelAndView("/inicio/Home", "command",null);
	}
	
	@RequestMapping(value="/inicio/local/borrar", method= RequestMethod.GET)
	public String borrar( Model model,HttpServletRequest request){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		LocalDao localdao = (LocalDaoImpl)context.getBean("iLocalImpl");
		String id =(String)request.getParameter("id");
		boolean flag = localdao.borrar(id);
		List<Local> locales = localdao.listar();
		model.addAttribute("locales", locales);
		
		if(flag){
			model.addAttribute("mensaje", "Local eliminado");
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
		return "inicio/local/listar";
		}
		}
			return "/inicio/Home";
	}
	
	
	@RequestMapping(value="/inicio/local/editar", method= RequestMethod.GET)
	public String editar( Model model,HttpServletRequest request){

		String tipo =(String)request.getParameter("tipo");
		model.addAttribute("tipo", tipo);
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		LocalDao localdao = (LocalDaoImpl)context.getBean("iLocalImpl");
		DistritoDao distritodao = (DistritoDaoImpl)context.getBean("iDistritoImpl");	
		List<Distrito> distritos = distritodao.listar();
		model.addAttribute("distritos", distritos);
		
		String id =(String)request.getParameter("id");
		Local local= localdao.obtenerid(id);
		
		model.addAttribute("local", local);
		
		
		
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return "inicio/homeuser";
			}
		if(user.getTipo()==2)
		{
		return "inicio/local/editar";
		}
		}
			return "/inicio/Home";
	}
	
	@RequestMapping(value="/inicio/local/editar", method= RequestMethod.POST)
	public String editar2( Model model,HttpServletRequest request){

		String tipo =(String)request.getParameter("tipo");
		model.addAttribute("tipo", tipo);
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		LocalDao localdao = (LocalDaoImpl)context.getBean("iLocalImpl");
		DistritoDao distritodao = (DistritoDaoImpl)context.getBean("iDistritoImpl");	
		List<Distrito> distritos = distritodao.listar();
		model.addAttribute("distritos", distritos);
		Local local = new Local();
		local.setId(Integer.parseInt( request.getParameter("id")));
		local.setNlocal(request.getParameter("nlocal"));
		local.setDireccion(request.getParameter("direccion"));
		local.setTelefono(request.getParameter("telefono"));
		local.setCorreo(request.getParameter("correo"));
		local.setDistrito(Integer.parseInt(request.getParameter("distrito")));
		boolean flag = false;
		
		
		if(local.getDireccion()=="" || local.getCorreo()=="")
		{
			model.addAttribute("mensaje", "Campo vacio");
		}else{if(!local.getNlocal().matches("[A-Za-z0-9]+"))
		{
			model.addAttribute("local", local);
			model.addAttribute("mensaje", "El nombre del local no debe tener caracteres especiales o vacio");
		}else{
			
			if(!local.getTelefono().matches("[0-9]{7,9}+"))
			{
				model.addAttribute("local", local);
				model.addAttribute("mensaje", "telefono deben ser un numero valido");
			}else{
				flag = localdao.editar(local);
		
		if(flag){
			model.addAttribute("mensaje", "Local Editado");
		}else{
			model.addAttribute("local", local);
			model.addAttribute("mensaje", "Ocurrió un error");
		}}}}
		
		
		
		
		
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return "inicio/homeuser";
			}
		if(user.getTipo()==2)
		{

			if(flag){
				List<Local> locales = localdao.listar();
				model.addAttribute("locales", locales);
				return "inicio/local/listar";}else
				{return "inicio/local/editar";}
		}
		}
			return "/inicio/Home";
	}
	
	
}
