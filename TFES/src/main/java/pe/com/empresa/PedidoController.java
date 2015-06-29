package pe.com.empresa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.com.modelo.Pedido;
import pe.com.modelo.Usuario;
import pe.com.service.PedidoDao;
import pe.com.service.PedidoDaoImpl;
import pe.com.service.UsuarioDao;
import pe.com.service.UsuarioDaoImpl;
@Controller
public class PedidoController {
	
	@RequestMapping(value="/inicio/pedido", method= RequestMethod.GET)
	public String listar(Model model,HttpServletRequest request){
		String tipo =(String)request.getParameter("tipo");
		model.addAttribute("tipo", tipo);
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		PedidoDao pedidodao = (PedidoDaoImpl)context.getBean("iPedidoImpl");
		UsuarioDao usuariodao = (UsuarioDaoImpl)context.getBean("iUsuarioImpl");
		
		List<Pedido> pedidos = pedidodao.listar();
		List<Usuario> usuarios = usuariodao.listar();
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("usuarios", usuarios);
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return "/inicio/homeuser";
			}
		if(user.getTipo()==2)
		{
			return "/inicio/homeadmin";
		}
		if(user.getTipo()==3)
		{
			return "/inicio/pedido/listar";
		}
		}
		return "/inicio/Home";
	}
	
	
	
	
		
	
	
	@RequestMapping(value="/inicio/pedido/actualizar", method= RequestMethod.GET)
	public String borrar( Model model,HttpServletRequest request){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		PedidoDao pedidodao = (PedidoDaoImpl)context.getBean("iPedidoImpl");
		UsuarioDao usuariodao = (UsuarioDaoImpl)context.getBean("iUsuarioImpl");
		String id =(String)request.getParameter("id");
		String tipo =(String)request.getParameter("tipo");
		boolean flag = pedidodao.cambiarestado(id);
		
		List<Pedido> pedidos = pedidodao.listar();
		List<Usuario> usuarios = usuariodao.listar();
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("tipo", tipo);
		if(flag){
			model.addAttribute("mensaje", "Pedido Actualizado");
		}else{
			model.addAttribute("mensaje", "Ocurrió un error");
		}
		
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return "/inicio/homeuser";
			}
		if(user.getTipo()==2)
		{
			return "/inicio/homeadmin";
		}
		if(user.getTipo()==3)
		{
			return "/inicio/pedido/listar";
		}
		}
		return "/inicio/Home";
	}
	
	
	
	
	
}
