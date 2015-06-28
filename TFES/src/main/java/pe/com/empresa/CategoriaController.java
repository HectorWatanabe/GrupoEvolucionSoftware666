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
import pe.com.modelo.Usuario;
import pe.com.service.CategoriaDao;
import pe.com.service.CategoriaDaoImpl;
@Controller
public class CategoriaController {
	
	@RequestMapping(value="/inicio/categoria/listado", method= RequestMethod.GET)
	public String listar(Model model,HttpServletRequest request){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		CategoriaDao categoriadao = (CategoriaDaoImpl)context.getBean("iCategoriaImpl");
		
		List<Categoria> categorias = categoriadao.listar();
		model.addAttribute("categorias", categorias);
		
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return "/inicio/homeuser";
			}
		if(user.getTipo()==2)
		{
			return "/inicio/categoria/listar";
		}
		}
		return "/inicio/Home";
		
		
	}
	
	@RequestMapping(value="/inicio", method= RequestMethod.GET)
	public ModelAndView inicio(){
		
		return new ModelAndView("inicio/Home", "command", new Categoria());
	}
	
	
	
	@RequestMapping(value="/inicio/categoria", method= RequestMethod.GET)
	public ModelAndView categoria(HttpServletRequest request){
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return new ModelAndView("/inicio/homeuser", "command",null);
			}
		if(user.getTipo()==2)
		{
			return new ModelAndView("inicio/categoria/agregar", "command", new Categoria());
		}
		}
		return new ModelAndView("/inicio/Home", "command",null);
		
	}
	
	@RequestMapping(value="/inicio/categoria/agregar", method= RequestMethod.POST)
	public String categoria(Categoria categoria, Model model,HttpServletRequest request){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		CategoriaDao categoriadao = (CategoriaDaoImpl)context.getBean("iCategoriaImpl");
		
		boolean flag = categoriadao.agregar(categoria);
		
		if(flag){
			model.addAttribute("mensaje", "Categoria guardado");
		}else{
			model.addAttribute("mensaje", "Ocurri� un error");
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
		return "inicio/mensaje";
		}
		}
			return "/inicio/Home";
	}
	
	
}
