package mz.djm.via.be.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import mz.djm.via.be.dao.QGisEntityDAOImpl.QGisEntityMapper;

public class QGisEntityDAOImplTest extends QGisDAOImplTest {

	private QGisEntityDAO gisDAO;
	
	@Before
	public void setUp() throws Exception {
		
		this.gisDAO = new QGisEntityDAOImpl();
	}

	@Test
	public void testGisRowsWith2ParametersMayNotBeEmpty(){
		
		assertEquals(1, this.gisDAO.getRowsBy("SELECT * FROM dados23032021;", new QGisEntityMapper()).size());
	}
	
	/*
	 * This is an integration test
	 */
	@Test
	public void testGisRowsWithNoParameterMustBeEmpty(){
		
		assertEquals(0, this.gisDAO.getRows().size());
	}
}
