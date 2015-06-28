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
import pe.com.modelo.Producto;
import pe.com.modelo.Usuario;
import pe.com.service.CategoriaDao;
import pe.com.service.CategoriaDaoImpl;
import pe.com.service.ProductoDao;
import pe.com.service.ProductoDaoImpl;
@Controller
public class ProductoController {
	
	@RequestMapping(value="/inicio/producto/listado", method= RequestMethod.GET)
	public String listar(Model model,HttpServletRequest request){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		ProductoDao productodao = (ProductoDaoImpl)context.getBean("iProductoImpl");
		
		List<Producto> productos = productodao.listar();
		model.addAttribute("productos", productos);
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return "/inicio/homeuser";
			}
		if(user.getTipo()==2)
		{
			return "/inicio/producto/listar";
		}
		}
		return "/inicio/Home";
		
	}
	
	@RequestMapping(value="/inicio/producto/listado1", method= RequestMethod.GET)
	public String listar1(Model model,HttpServletRequest request){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		ProductoDao productodao = (ProductoDaoImpl)context.getBean("iProductoImpl");
		
		List<Producto> productos = productodao.listar();
		model.addAttribute("productos", productos);
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return "/inicio/producto/listar2";
			}
		}
			return "/inicio/producto/listar1";
		
	}
	
	@RequestMapping(value="/inicio/producto", method= RequestMethod.GET)
	public ModelAndView producto(Model model,HttpServletRequest request){

		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		CategoriaDao categoriadao = (CategoriaDaoImpl)context.getBean("iCategoriaImpl");
		
		List<Categoria> categorias = categoriadao.listar();
		model.addAttribute("categorias", categorias);
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return new ModelAndView("/inicio/homeuser", "command",null);
			}
		if(user.getTipo()==2)
		{
			return new ModelAndView("inicio/producto/agregar", "command", new Producto());
		}
		}
		return new ModelAndView("/inicio/Home", "command",null);
		
	}
	
	
	@RequestMapping(value="/inicio/producto/agregar", method= RequestMethod.POST)
	public String producto(Producto producto, Model model,HttpServletRequest request){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		ProductoDao productodao = (ProductoDaoImpl)context.getBean("iProductoImpl");
		
		boolean flag = productodao.agregar(producto);
		
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
	@RequestMapping(value="/inicio/producto/promo", method= RequestMethod.GET)
	public ModelAndView promocion(Model model){

		return new ModelAndView("inicio/producto/promociones", "command", null);
	}
	//-----------------------------------PEDIDO-----------------------------------------------
	@RequestMapping(value="/inicio/pedido/listado", method= RequestMethod.GET)
	public String pedido(Model model,HttpServletRequest request){
		
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
