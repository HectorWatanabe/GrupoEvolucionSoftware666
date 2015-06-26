package pe.com.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import pe.com.modelo.Categoria;
import pe.com.modelo.Distrito;
import pe.com.modelo.Local;
import pe.com.modelo.Producto;
import pe.com.modelo.Usuario;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/SpringBean.xml"})
@TransactionConfiguration(defaultRollback=true)
public class CategoriaDaoTest {
	@Autowired
	private JdbcTemplate jdbcTemp;
	@Autowired
	public void setJdbcTemp(JdbcTemplate jdbcTemp) {
		this.jdbcTemp = jdbcTemp;
	}
	@Autowired
	LocalDaoImpl localdaoimpl;
	@Autowired
	DistritoDaoImpl distritodaoimpl;
	@Autowired
	ProductoDaoImpl productodaoimpl;
	@Autowired
	CategoriaDaoImpl categoriadaoimpl;
	@Autowired
	UsuarioDaoImpl usuariodaoimpl;
	
	//---------------Producto--------------
	@Test
	@Rollback
	public void testProductoAgregar() {
		int num=productodaoimpl.listar().size();
		Producto producto= new Producto();
		producto.setNproducto("productoprueba");
		producto.setDescripcion("descripcionrueba");
		producto.setCategoria_id(2);
		producto.setPrecio(23);
		productodaoimpl.agregar(producto);
		
		assertEquals(num+1, productodaoimpl.listar().size());
	}
	@Test
	public void testProductoListar()
	{
		assertEquals(3, productodaoimpl.listar().size());
	}
	
	
	//---------------Local--------------
	@Test
	@Rollback
	public void testxLocalAgregar() {
		int num=localdaoimpl.listar().size();
		Local local= new Local();
		local.setNlocal("localprueba");
		local.setDistrito(1);
		local.setCorreo("correoprueba");
		local.setDireccion("direccionprueba");
		local.setTelefono(1234567);
		localdaoimpl.agregar(local);
		
		assertEquals(num+1, localdaoimpl.listar().size());
	}
	@Test
	public void testLocalListar()
	{
		assertEquals(2, localdaoimpl.listar().size());
	}
	
	
	//---------------Categoria--------------
	@Test
	@Rollback
	public void testCategoriaAgregar() {
		int num=categoriadaoimpl.listar().size();
		Categoria categoria= new Categoria();
		categoria.setNcategoria("categoriaprueba");
		categoriadaoimpl.agregar(categoria);

		assertEquals(num+1, categoriadaoimpl.listar().size());
	}
	@Test
	public void testxCategoriaListar()
	{
		assertEquals(6, categoriadaoimpl.listar().size());
	}
	//---------------Distrito--------------
	@Test
	@Rollback
	public void testDistritoAgregar() {
		int num=distritodaoimpl.listar().size();
		Distrito distrito= new Distrito();
		distrito.setNdistrito("Persona2");
		distritodaoimpl.agregar(distrito);
		
		assertEquals(num+1, distritodaoimpl.listar().size());
	}
	@Test
	public void testDistritoListar()
	{
		assertEquals(9, distritodaoimpl.listar().size());
	}
	//---------------Usuario--------------
	@Test
	@Rollback
	public void testUsuarioAgregar() {
		int num=usuariodaoimpl.listar().size();
		Usuario usuario= new Usuario();
		usuario.setAusuario("ausuarioprueba");
		usuario.setNusuario("nusuarioprueba");
		usuario.setUsuario("usuarioprueba");
		usuario.setDni(12345678);
		usuario.setDireccion("direccionprueba");
		usuario.setNacimiento(1993);
		usuario.setTelefono(123456789);
		usuario.setTipo(1);
		usuario.setClave("claveprueba");
		usuariodaoimpl.agregar(usuario);
		
		assertEquals(num+1, usuariodaoimpl.listar().size());
	}
	@Test
	public void testUsuarioListar()
	{
		assertEquals(3, usuariodaoimpl.listar().size());
	}
}
