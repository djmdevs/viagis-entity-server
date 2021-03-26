package mz.djm.via.be.rule;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;

import mz.djm.via.be.dao.QGisDAOImplTest;
import mz.djm.via.be.dao.QGisEntityDAO;
import mz.djm.via.be.dao.QGisEntityDAOImpl;
import mz.djm.via.be.entity.QGiSEntity;

public class CriterioRuleTest{

	private QGisEntityDAO gisdao;
	private IRule rules;
	
	@Before
	public void setUp() throws Exception {
		
		gisdao = QGisEntityDAOImpl.getInstance();
		rules  = new CriterioRule();
	}

	
	/**
	 * Integration Test
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCalcularICPwithDefeitoRule10() {
		
		 //get segmento
		final QGiSEntity segmento = this.gisdao.findRowBy(new String[] {"objectid","1"});
		
		assertEquals(new Long(4).longValue(), segmento.objectid.longValue());
		
		//calculate icpRule10
	    // final double icp = rules.executeRule10(, totalDefeitos):
	
	}

}
