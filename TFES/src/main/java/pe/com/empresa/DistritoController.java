package pe.com.empresa;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.com.modelo.Distrito;
import pe.com.service.DistritoDao;
import pe.com.service.DistritoDaoImpl;
@Controller
public class DistritoController {
	
	@RequestMapping(value="/inicio/distrito/listado", method= RequestMethod.GET)
	public String listar(Model model){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		DistritoDao distritodao = (DistritoDaoImpl)context.getBean("iDistritoImpl");
		
		List<Distrito> distritos = distritodao.listar();
		model.addAttribute("distritos", distritos);
		
		return "/inicio/distrito/listar";
	}
	
	@RequestMapping(value="/inicio/distrito", method= RequestMethod.GET)
	public ModelAndView distrito(){
		
		return new ModelAndView("inicio/distrito/agregar", "command", new Distrito());
	}

	
	@RequestMapping(value="/inicio/distrito/agregar", method= RequestMethod.POST)
	public String distrito(Distrito distrito, Model model){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		DistritoDao distritodao = (DistritoDaoImpl)context.getBean("iDistritoImpl");
		
		boolean flag = distritodao.agregar(distrito);
		
		if(flag){
			model.addAttribute("mensaje", "Distrito guardado");
		}else{
			model.addAttribute("mensaje", "Ocurrió un error");
		}
		
		return "inicio/mensaje";
	}
	
	
}
