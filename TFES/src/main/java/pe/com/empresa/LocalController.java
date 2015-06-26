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
import pe.com.modelo.Local;
import pe.com.service.DistritoDao;
import pe.com.service.DistritoDaoImpl;
import pe.com.service.LocalDao;
import pe.com.service.LocalDaoImpl;
@Controller
public class LocalController {
	
	@RequestMapping(value="/inicio/local/listado", method= RequestMethod.GET)
	public String listar(Model model){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		LocalDao localdao = (LocalDaoImpl)context.getBean("iLocalImpl");
		DistritoDao distritodao = (DistritoDaoImpl)context.getBean("iDistritoImpl");
		
		List<Local> locales = localdao.listar();
		List<Distrito> distritos = distritodao.listar();
		model.addAttribute("locales", locales);
		model.addAttribute("distritos", distritos);
		
		return "/inicio/local/listar";
	}
	
	
	@RequestMapping(value="/inicio/local", method= RequestMethod.GET)
	public ModelAndView categoria(Model model){

		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		DistritoDao distritodao = (DistritoDaoImpl)context.getBean("iDistritoImpl");
		
		List<Distrito> distritos = distritodao.listar();
		model.addAttribute("distritos", distritos);
		
		return new ModelAndView("inicio/local/agregar", "command", new Local());
	}
	
	@RequestMapping(value="/inicio/local/agregar", method= RequestMethod.POST)
	public String local(Local local, Model model){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		LocalDao localdao = (LocalDaoImpl)context.getBean("iLocalImpl");
		
		boolean flag = localdao.agregar(local);
		
		if(flag){
			model.addAttribute("mensaje", "Local guardado");
		}else{
			model.addAttribute("mensaje", "Ocurrió un error");
		}
		
		return "inicio/mensaje";
	}
	
	
}
