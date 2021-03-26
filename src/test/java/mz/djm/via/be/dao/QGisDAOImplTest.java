package mz.djm.via.be.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

import mz.djm.via.be.datasource.QGisDatasource;

public class QGisDAOImplTest {

	protected static JdbcTemplate jdbc;  
	protected static QGisDatasource datasource;
	protected static Resource resource;
	
	@BeforeClass
	public static void init() throws IOException {
		
		//pega base 
		resource = new ClassPathResource("dados23032021.sqlite");			
		datasource = new QGisDatasource(resource);
 	    jdbc = new JdbcTemplate(datasource);
	}
	
	
	@Test
	public void testVerifyResourceExistence() {
		
		assertNotNull("ResourceNotNull", resource);
	}
	
	@Test
	public void testCheckWrongResourceFilename() {
		
		assertEquals("spatial-test-db.sqlite", resource.getFilename());
	}
	
	@Test
	public void testCheckIfFilenamePathIsInResource() throws IOException {
		
		assertEquals("spatial-test-db.sqlite", resource.getFile().getPath());
	}
	
	@Test//(expected = SQLException.class)
	public void testCheckIfConnetionExists() throws SQLException {
		
		assertNotNull(datasource.getConnection());
	}
	

}
