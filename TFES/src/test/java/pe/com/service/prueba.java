package pe.com.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import pe.com.modelo.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/SpringBean.xml"})
@TransactionConfiguration(defaultRollback=true)
public class prueba {

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

}
