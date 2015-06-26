package pe.com.empresa;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.com.modelo.Categoria;
import pe.com.service.CategoriaDao;
import pe.com.service.CategoriaDaoImpl;
@Controller
public class CategoriaController {
	
	@RequestMapping(value="/inicio/categoria/listado", method= RequestMethod.GET)
	public String listar(Model model){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		CategoriaDao categoriadao = (CategoriaDaoImpl)context.getBean("iCategoriaImpl");
		
		List<Categoria> categorias = categoriadao.listar();
		model.addAttribute("categorias", categorias);
		
		return "/inicio/categoria/listar";
	}
	
	@RequestMapping(value="/inicio", method= RequestMethod.GET)
	public ModelAndView inicio(){
		
		return new ModelAndView("inicio/homeadmin", "command", new Categoria());
	}
	
	@RequestMapping(value="/inicio/categoria", method= RequestMethod.GET)
	public ModelAndView categoria(){
		
		return new ModelAndView("inicio/categoria/agregar", "command", new Categoria());
	}
	
	@RequestMapping(value="/inicio/categoria/agregar", method= RequestMethod.POST)
	public String categoria(Categoria categoria, Model model){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		CategoriaDao categoriadao = (CategoriaDaoImpl)context.getBean("iCategoriaImpl");
		
		boolean flag = categoriadao.agregar(categoria);
		
		if(flag){
			model.addAttribute("mensaje", "Categoria guardado");
		}else{
			model.addAttribute("mensaje", "Ocurrió un error");
		}
		
		return "inicio/mensaje";
	}
	
	
}
