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
	
	@RequestMapping(value="/inicio/local/agregar", method= RequestMethod.POST)
	public String local(Local local, Model model,HttpServletRequest request){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		LocalDao localdao = (LocalDaoImpl)context.getBean("iLocalImpl");
		
		boolean flag = localdao.agregar(local);
		
		if(flag){
			model.addAttribute("mensaje", "Local guardado");
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
