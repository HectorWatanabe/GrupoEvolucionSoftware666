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
import pe.com.modelo.Producto;
import pe.com.service.CategoriaDao;
import pe.com.service.CategoriaDaoImpl;
import pe.com.service.ProductoDao;
import pe.com.service.ProductoDaoImpl;
@Controller
public class ProductoController {
	
	@RequestMapping(value="/inicio/producto/listado", method= RequestMethod.GET)
	public String listar(Model model){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		ProductoDao productodao = (ProductoDaoImpl)context.getBean("iProductoImpl");
		
		List<Producto> productos = productodao.listar();
		model.addAttribute("productos", productos);
		
		return "/inicio/producto/listar";
	}
	
	
	@RequestMapping(value="/inicio/producto", method= RequestMethod.GET)
	public ModelAndView producto(Model model){

		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		CategoriaDao categoriadao = (CategoriaDaoImpl)context.getBean("iCategoriaImpl");
		
		List<Categoria> categorias = categoriadao.listar();
		model.addAttribute("categorias", categorias);
		
		return new ModelAndView("inicio/producto/agregar", "command", new Producto());
	}
	
	@RequestMapping(value="/inicio/producto/agregar", method= RequestMethod.POST)
	public String producto(Producto producto, Model model){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		ProductoDao productodao = (ProductoDaoImpl)context.getBean("iProductoImpl");
		
		boolean flag = productodao.agregar(producto);
		
		if(flag){
			model.addAttribute("mensaje", "Local guardado");
		}else{
			model.addAttribute("mensaje", "Ocurrió un error");
		}
		
		return "inicio/mensaje";
	}
	
	
}
