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

import pe.com.modelo.Categoria;
import pe.com.modelo.Distrito;
import pe.com.modelo.Usuario;
import pe.com.service.DistritoDao;
import pe.com.service.DistritoDaoImpl;
@Controller
public class DistritoController {
	
	@RequestMapping(value="/inicio/distrito/listado", method= RequestMethod.GET)
	public String listar(Model model,HttpServletRequest request){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		DistritoDao distritodao = (DistritoDaoImpl)context.getBean("iDistritoImpl");
		
		List<Distrito> distritos = distritodao.listar();
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
			return "/inicio/distrito/listar";
		}
		if(user.getTipo()==3)
		{
			return "/inicio/homecocinero";
		}
		}
		return "/inicio/Home";
		
	}
	@RequestMapping(value="/inicio/distrito/borrar", method= RequestMethod.GET)
	public String borrar( Model model,HttpServletRequest request){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		DistritoDao distritodao = (DistritoDaoImpl)context.getBean("iDistritoImpl");
		String id =(String)request.getParameter("id");
		boolean flag = distritodao.borrar(id);

		List<Distrito> distritos = distritodao.listar();
		model.addAttribute("distritos", distritos);
		if(flag){
			model.addAttribute("mensaje", "Distrito Eliminado");
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
		return "inicio/distrito/listar";
		}
		if(user.getTipo()==3)
		{
			return "/inicio/homecocinero";
		}
		}
			return "/inicio/Home";
	}
	@RequestMapping(value="/inicio/distrito", method= RequestMethod.GET)
	public ModelAndView distrito(HttpServletRequest request){
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return new ModelAndView("/inicio/homeuser", "command",null);
			}
		if(user.getTipo()==2)
		{

			return new ModelAndView("inicio/distrito/agregar", "command", new Distrito());
		}
		if(user.getTipo()==3)
		{
		return new ModelAndView("inicio/homecocinero", "command", new Categoria());
		}
		}
		return new ModelAndView("/inicio/Home", "command",null);
	}

	
	@RequestMapping(value="/inicio/distrito", method= RequestMethod.POST)
	public ModelAndView distrito(Distrito distrito, Model model,HttpServletRequest request){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		DistritoDao distritodao = (DistritoDaoImpl)context.getBean("iDistritoImpl");
		boolean flag=false;
		if(!distrito.getNdistrito().matches("[A-Za-z0-9]+"))
		{
			model.addAttribute("mensaje", "El nombre del distrito no debe tener caracteres especiales o estar en blanco");
		}else{
		flag = distritodao.agregar(distrito);
		
		if(flag){
			model.addAttribute("mensaje", "Distrito guardado");
		}else{
			model.addAttribute("mensaje", "Ocurrió un error");
		}}
		
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return new ModelAndView("/inicio/homeuser", "command",null);
			}
		if(user.getTipo()==2)
		{
			return new ModelAndView("inicio/distrito/agregar", "command", new Distrito());
		}
		if(user.getTipo()==3)
		{
		return new ModelAndView("inicio/homecocinero", "command", new Categoria());
		}
		}
		return new ModelAndView("/inicio/Home", "command",null);
	}
	
	
	
	@RequestMapping(value="/inicio/distrito/editar", method= RequestMethod.GET)
	public String editar( Model model,HttpServletRequest request){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		DistritoDao distritodao = (DistritoDaoImpl)context.getBean("iDistritoImpl");
		String id =(String)request.getParameter("id");
		Distrito distrito= distritodao.obtenerid(id);
		
		model.addAttribute("distrito", distrito);
		
		
		
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return "inicio/homeuser";
			}
		if(user.getTipo()==2)
		{
		return "inicio/distrito/editar";
		}
		if(user.getTipo()==3)
		{
			return "/inicio/homecocinero";
		}
		}
			return "/inicio/Home";
	}
	
	@RequestMapping(value="/inicio/distrito/editar", method= RequestMethod.POST)
	public String editar2( Model model,HttpServletRequest request){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		DistritoDao distritodao = (DistritoDaoImpl)context.getBean("iDistritoImpl");
		Distrito distrito = new Distrito();
		distrito.setId(Integer.parseInt( request.getParameter("id")));
		distrito.setNdistrito(request.getParameter("ndistrito"));
		boolean flag = false;
		
		
		if(!distrito.getNdistrito().matches("[A-Za-z0-9]+"))
		{
			model.addAttribute("distrito", distrito);
			model.addAttribute("mensaje", "El nombre del distrito no debe tener caracteres especiales o estar en blanco");
		}else{
			flag = distritodao.editar(distrito);
		
		if(flag){
			model.addAttribute("mensaje", "Distrito editado");
		}else{
			model.addAttribute("distrito", distrito);
			model.addAttribute("mensaje", "Ocurrió un error");
		}}
		
		
		
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
				List<Distrito> distritos = distritodao.listar();
				model.addAttribute("distritos", distritos);
				return "inicio/distrito/listar";}else
				{return "inicio/distrito/editar";}
		}
		if(user.getTipo()==3)
		{
			return "/inicio/homecocinero";
		}
		}
			return "/inicio/Home";
	}
	
}
