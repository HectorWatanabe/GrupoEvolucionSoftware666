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
import pe.com.modelo.Pedido;
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
	@Autowired
	PedidoDaoImpl pedidodaoimpl;
	
	//---------------Producto--------------
	@Test
	@Rollback
	public void testProductoAgregar() {
		int num=productodaoimpl.listar().size();
		Producto producto= new Producto();
		producto.setNproducto("prod3");
		producto.setDescripcion("descripcionrueba");
		producto.setCategoria_id(2);
		producto.setPrecio(23);
		productodaoimpl.agregar(producto);
		
		assertEquals(num+1, productodaoimpl.listar().size());
	}
	@Test
	public void testProductoListar()
	{
		assertEquals(14, productodaoimpl.listar().size());
	}
	@Test
	public void testGetProducto() {
		
		Producto producto= productodaoimpl.obtenerid("3");

		assertNotNull(producto);
	}
	@Test
	public void testGetProductoS() {
		
		Producto producto= productodaoimpl.obtenerpro("Suspiro");

		assertNotNull(producto);
	}
	
	@Test
	public void testxBorrarProducto() {
		
		int num=productodaoimpl.listar().size();
		productodaoimpl.borrar("32");
		
		assertEquals(num-1, productodaoimpl.listar().size());
	}
	
	@Test
	public void testEditarProducto() {
		
		Producto producto= new Producto();
		producto.setId(13);
		producto.setNproducto("editad333");
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
		local.setNlocal("local6666");
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
		assertEquals(13, localdaoimpl.listar().size());
	}
	@Test
	public void testGetLocal() {
		
		Local local= localdaoimpl.obtenerid("3");

		assertNotNull(local);
	}
	@Test
	public void testGetLocalS() {
		
		Local local= localdaoimpl.obtenerlocal("salaverry");

		assertNotNull(local);
	}
	
	@Test
	public void testxBorrarLocal() {
		
		int num=localdaoimpl.listar().size();
		localdaoimpl.borrar("38");
		
		assertEquals(num-1, localdaoimpl.listar().size());
	}
	
	@Test
	public void testEditarLocal() {
		
		Local local= new Local();
		local.setId(13);
		local.setNlocal("edit666");
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
		categoria.setNcategoria("cate2");
		categoriadaoimpl.agregar(categoria);

		assertEquals(num+1, categoriadaoimpl.listar().size());
	}
	@Test
	public void testxCategoriaListar()
	{
		assertEquals(4, categoriadaoimpl.listar().size());
	}
	
	@Test
	public void testGetCategoria() {
		
		Categoria categoria= categoriadaoimpl.obtenerid("3");

		assertNotNull(categoria);
	}
	@Test
	public void testGetCategoriaS() {
		
		Categoria categoria= categoriadaoimpl.obtenercat("Carnes");

		assertNotNull(categoria);
	}
	
	@Test
	public void testxBorrarCategorial() {
		
		int num=categoriadaoimpl.listar().size();
		categoriadaoimpl.borrar("42");
		
		assertEquals(num-1, categoriadaoimpl.listar().size());
	}
	
	@Test
	public void testEditarCategoria() {
		
		Categoria categoria= new Categoria();
		categoria.setId(2);
		categoria.setNcategoria("dao565");
		
	    boolean resulto=categoriadaoimpl.editar(categoria);
		
		assertTrue(resulto);
	}
	//---------------Distrito--------------
	@Test
	@Rollback
	public void testDistritoAgregar() {
		int num=distritodaoimpl.listar().size();
		Distrito distrito= new Distrito();
		distrito.setNdistrito("dis333");
		distritodaoimpl.agregar(distrito);
		
		assertEquals(num+1, distritodaoimpl.listar().size());
	}
	@Test
	public void testDistritoListar()
	{
		assertEquals(4, distritodaoimpl.listar().size());
	}
	
	@Test
	public void testGetDistrito() {
		
		Distrito distrito= distritodaoimpl.obtenerid("1");

		assertNotNull(distrito);
	}
	
	@Test
	public void testxBorrarDistrito() {
		
		int num=distritodaoimpl.listar().size();
		distritodaoimpl.borrar("40");
		
		assertEquals(num-1, distritodaoimpl.listar().size());
	}
	
	@Test
	public void testEditarDistrito() {
		
		Distrito distrito= new Distrito();
		distrito.setId(4);
		distrito.setNdistrito("dao");
		
	    boolean resulto=distritodaoimpl.editar(distrito);
		
		assertTrue(resulto);
	}
	@Test
	public void testGetDistritoS() {
		
		Distrito distrito= distritodaoimpl.obtenerdistrito("surco");

		assertNotNull(distrito);
	}
	
	//---------------Usuario--------------
	@Test
	@Rollback
	public void testUsuarioAgregar() {
		int num=usuariodaoimpl.listar().size();
		Usuario usuario= new Usuario();
		usuario.setAusuario("ausuarioprueba");
		usuario.setNusuario("nusuarioprueba");
		usuario.setUsuario("usuario6666");
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
	//------------Pedido----------------------
	@Test
	public void testPedidoListar()
	{
		assertEquals(13, pedidodaoimpl.listar().size());
	}
	
	@Test
	public void testGetPedido() {
		
		Pedido pedido= pedidodaoimpl.obtenerPedido("2");

		assertNotNull(pedido);
	}
	
	@Test
	public void testxEditarPedido() {
		
		boolean num=pedidodaoimpl.cambiarestado("2");
		
		assertTrue(num);
	}
}
