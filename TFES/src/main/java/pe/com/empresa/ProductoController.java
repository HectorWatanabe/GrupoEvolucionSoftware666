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
		String tipo =(String)request.getParameter("tipo");
		model.addAttribute("tipo", tipo);
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		ProductoDao productodao = (ProductoDaoImpl)context.getBean("iProductoImpl");
		CategoriaDao categoriadao = (CategoriaDaoImpl)context.getBean("iCategoriaImpl");
		List<Categoria> categorias = categoriadao.listar();
		model.addAttribute("categorias", categorias);
		
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
		String tipo =(String)request.getParameter("tipo");
		model.addAttribute("tipo", tipo);
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		ProductoDao productodao = (ProductoDaoImpl)context.getBean("iProductoImpl");
		CategoriaDao categoriadao = (CategoriaDaoImpl)context.getBean("iCategoriaImpl");
		List<Categoria> categorias = categoriadao.listar();
		model.addAttribute("categorias", categorias);
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
	
	
	@RequestMapping(value="/inicio/producto", method= RequestMethod.POST)
	public ModelAndView producto(Producto producto, Model model,HttpServletRequest request){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		ProductoDao productodao = (ProductoDaoImpl)context.getBean("iProductoImpl");
		CategoriaDao categoriadao = (CategoriaDaoImpl)context.getBean("iCategoriaImpl");
		boolean flag=false;
		if(producto.getDescripcion()=="")
		{model.addAttribute("mensaje", "Campo vacio");}else{
		if(!producto.getNproducto().matches("[A-Za-z0-9]+"))
		{
			model.addAttribute("mensaje", "El nombre del producto no debe tener caracteres especiales");
		}else
		{

			flag = productodao.agregar(producto);
			if(flag){
				model.addAttribute("mensaje", "Producto guardado");
			}
			else{model.addAttribute("mensaje", "Ocurrio un Error");}
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
			List<Categoria> categorias = categoriadao.listar();
			model.addAttribute("categorias", categorias);
			return new ModelAndView("inicio/producto/agregar", "command", new Producto());
		}
		}
		return new ModelAndView("/inicio/Home", "command",null);
	}
	@RequestMapping(value="/inicio/producto/promo", method= RequestMethod.GET)
	public ModelAndView promocion(Model model){

		return new ModelAndView("inicio/producto/promociones", "command", null);
	}
	
	
	@RequestMapping(value="/inicio/producto/borrar", method= RequestMethod.GET)
	public String borrar( Model model,HttpServletRequest request){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		ProductoDao productodao = (ProductoDaoImpl)context.getBean("iProductoImpl");
		String id =(String)request.getParameter("id");
		boolean flag = productodao.borrar(id);
		List<Producto> productos = productodao.listar();
		model.addAttribute("productos", productos);
		
		if(flag){
			model.addAttribute("mensaje", "Producto Eliminado");
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
		return "inicio/producto/listar";
		}
		}
			return "/inicio/Home";
	}
	
	
	@RequestMapping(value="/inicio/producto/editar", method= RequestMethod.GET)
	public String editar( Model model,HttpServletRequest request){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		ProductoDao productodao = (ProductoDaoImpl)context.getBean("iProductoImpl");
		CategoriaDao categoriadao = (CategoriaDaoImpl)context.getBean("iCategoriaImpl");	
		List<Categoria> categorias = categoriadao.listar();
		model.addAttribute("categorias", categorias);
		String id =(String)request.getParameter("id");
		Producto producto= productodao.obtenerid(id);
		
		model.addAttribute("producto", producto);
		
		
		
		Usuario user=(Usuario)request.getSession().getAttribute("usuario");
		if(request.getSession().getAttribute("usuario")!=null)
		{
		if(user.getTipo()==1)
			{
			return "inicio/homeuser";
			}
		if(user.getTipo()==2)
		{
		return "inicio/producto/editar";
		}
		}
			return "/inicio/Home";
	}
	
	@RequestMapping(value="/inicio/producto/editar", method= RequestMethod.POST)
	public String editar2( Model model,HttpServletRequest request){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		ProductoDao productodao = (ProductoDaoImpl)context.getBean("iProductoImpl");
		CategoriaDao categoriadao = (CategoriaDaoImpl)context.getBean("iCategoriaImpl");	
		List<Categoria> categorias = categoriadao.listar();
		model.addAttribute("categorias", categorias);
		Producto producto = new Producto();
		producto.setId(Integer.parseInt( request.getParameter("id")));
		producto.setNproducto(request.getParameter("nproducto"));
		producto.setDescripcion(request.getParameter("descripcion"));
		producto.setCategoria_id(Integer.parseInt(request.getParameter("categoria_id")));
		producto.setPrecio(Float.parseFloat(request.getParameter("precio")));
		boolean flag = false;
		
		
		
		if(producto.getDescripcion()=="")
		{model.addAttribute("producto", producto);
		model.addAttribute("mensaje", "Campo vacio");}else{
		if(!producto.getNproducto().matches("[A-Za-z0-9]+"))
		{
			model.addAttribute("producto", producto);
			model.addAttribute("mensaje", "El nombre del producto no debe tener caracteres especiales");
		}else
		{

			flag = productodao.editar(producto);
			
			if(flag){
				model.addAttribute("mensaje", "Producto editado");
			}
			else{model.addAttribute("producto", producto);model.addAttribute("mensaje", "Ocurrio un Error");}
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
				List<Producto> productos = productodao.listar();
				model.addAttribute("productos", productos);
				return "inicio/producto/listar";}else
				{return "inicio/producto/editar";}
		}
		}
			return "/inicio/Home";
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
