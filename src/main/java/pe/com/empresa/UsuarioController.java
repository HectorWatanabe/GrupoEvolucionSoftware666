package pe.com.empresa;

import java.util.List;

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
	
	@RequestMapping(value="/inicio/usuario/agregar", method= RequestMethod.POST)
	public String usuario(Usuario usuario, Model model){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		UsuarioDao usuariodao = (UsuarioDaoImpl)context.getBean("iUsuarioImpl");
		
		boolean flag = usuariodao.agregar(usuario);
		
		if(flag){
			model.addAttribute("mensaje", "Usuario guardado");
		}else{
			model.addAttribute("mensaje", "Ocurrió un error");
		}
		
		return "inicio/mensaje";
	}
	
	
}
