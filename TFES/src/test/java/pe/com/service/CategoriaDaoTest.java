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
		assertEquals(5, productodaoimpl.listar().size());
	}
	@Test
	public void testGetProducto() {
		
		Producto producto= productodaoimpl.obtenerid("3");

		assertNotNull(producto);
	}
	
	@Test
	public void testxBorrarProducto() {
		
		int num=productodaoimpl.listar().size();
		productodaoimpl.borrar("22");
		
		assertEquals(num-1, productodaoimpl.listar().size());
	}
	
	@Test
	public void testEditarProducto() {
		
		Producto producto= new Producto();
		producto.setId(13);
		producto.setNproducto("editado");
		producto.setDescripcion("editado");
		producto.setCategoria_id(1);
		producto.setPrecio(66);
		
	    boolean resulto=productodaoimpl.editar(producto);
		
		assertTrue(resulto);
	}
	
	//---------------Local--------------
	@Test
	@Rollback
	public void testLocalAgregar() {
		int num=localdaoimpl.listar().size();
		Local local= new Local();
		local.setNlocal("localprueba");
		local.setDistrito(1);
		local.setCorreo("correoprueba");
		local.setDireccion("direccionprueba");
		local.setTelefono("1234567");
		localdaoimpl.agregar(local);
		
		assertEquals(num+1, localdaoimpl.listar().size());
	}
	@Test
	public void testxLocalListar()
	{
		assertEquals(5, localdaoimpl.listar().size());
	}
	@Test
	public void testGetLocal() {
		
		Local local= localdaoimpl.obtenerid("3");

		assertNotNull(local);
	}
	
	@Test
	public void testxBorrarLocal() {
		
		int num=localdaoimpl.listar().size();
		localdaoimpl.borrar("24");
		
		assertEquals(num-1, localdaoimpl.listar().size());
	}
	
	@Test
	public void testEditarLocal() {
		
		Local local= new Local();
		local.setId(13);
		local.setNlocal("editado");
		local.setCorreo("editado");
		local.setDireccion("editado");
		local.setDistrito(1);
		local.setTelefono("12345678");
		
	    boolean resulto=localdaoimpl.editar(local);
		
		assertTrue(resulto);
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
		assertEquals(5, categoriadaoimpl.listar().size());
	}
	
	@Test
	public void testGetCategoria() {
		
		Categoria categoria= categoriadaoimpl.obtenerid("3");

		assertNotNull(categoria);
	}
	
	@Test
	public void testxBorrarCategorial() {
		
		int num=categoriadaoimpl.listar().size();
		categoriadaoimpl.borrar("36");
		
		assertEquals(num-1, categoriadaoimpl.listar().size());
	}
	
	@Test
	public void testEditarCategoria() {
		
		Categoria categoria= new Categoria();
		categoria.setId(4);
		categoria.setNcategoria("editado");
		
	    boolean resulto=categoriadaoimpl.editar(categoria);
		
		assertTrue(resulto);
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
		assertEquals(5, distritodaoimpl.listar().size());
	}
	
	@Test
	public void testGetDistrito() {
		
		Distrito distrito= distritodaoimpl.obtenerid("1");

		assertNotNull(distrito);
	}
	
	@Test
	public void testxBorrarDistrito() {
		
		int num=distritodaoimpl.listar().size();
		distritodaoimpl.borrar("32");
		
		assertEquals(num-1, distritodaoimpl.listar().size());
	}
	
	@Test
	public void testEditarDistrito() {
		
		Distrito distrito= new Distrito();
		distrito.setId(4);
		distrito.setNdistrito("editado");
		
	    boolean resulto=distritodaoimpl.editar(distrito);
		
		assertTrue(resulto);
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
		usuario.setDni("12345678");
		usuario.setDireccion("direccionprueba");
		usuario.setNacimiento("12/11/s1993");
		usuario.setTelefono("123456789");
		usuario.setTipo(1);
		usuario.setClave("claveprueba");
		usuariodaoimpl.agregar(usuario);
		
		assertEquals(num+1, usuariodaoimpl.listar().size());
	}
	@Test
	public void testUsuarioListar()
	{
		assertEquals(5, usuariodaoimpl.listar().size());
	}
	
	
	
	@Test
	public void testGetUsuario() {
		
		Usuario usuario= usuariodaoimpl.obtenerid("admin");

		assertNotNull(usuario);
	}
	
	@Test
	public void testGetUsuarioDatos() {
		
		Usuario usuario= usuariodaoimpl.obtenerUser("1");

		assertNotNull(usuario);
	}
	
	@Test
	public void testxBorrarUsuario() {
		
		boolean num=usuariodaoimpl.borrar("2");
		
		assertTrue(num);
	}
	
}
