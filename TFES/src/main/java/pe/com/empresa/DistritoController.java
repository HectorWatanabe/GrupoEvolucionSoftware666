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
		}
		return new ModelAndView("/inicio/Home", "command",null);
	}

	
	@RequestMapping(value="/inicio/distrito/agregar", method= RequestMethod.POST)
	public String distrito(Distrito distrito, Model model,HttpServletRequest request){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		DistritoDao distritodao = (DistritoDaoImpl)context.getBean("iDistritoImpl");
		
		boolean flag = distritodao.agregar(distrito);
		
		if(flag){
			model.addAttribute("mensaje", "Distrito guardado");
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
		return "inicio/mensaje";
		}
		}
			return "/inicio/Home";
	}
	
	
}
