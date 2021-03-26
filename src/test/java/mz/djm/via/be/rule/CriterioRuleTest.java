package mz.djm.via.be.rule;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.UncategorizedSQLException;
import mz.djm.via.be.dao.QGisEntityDAO;
import mz.djm.via.be.dao.QGisEntityDAOImpl;
import mz.djm.via.be.entity.QGiSEntity;
import mz.djm.via.fe.entity.DefeitoType;
import mz.djm.via.fe.entity.SeguimentoVia;
import mz.djm.via.fe.entity.Template;

public class CriterioRuleTest{

	private QGisEntityDAO gisdao;
	private IRule rules;
	private Template template;
	
	@Before
	public void setUp() throws Exception {
		
		gisdao = QGisEntityDAOImpl.getInstance();
		rules  = new CriterioRule();
	}

	@Test(expected = UncategorizedSQLException.class)
	public void testCheckIfParameterExists() {
		
		String[] parameter = {"objectid","1"};
		
		//get segmento
		final QGiSEntity gisRow = this.gisdao.findRowBy(parameter);
		
		assertEquals("1", gisRow.objectid);
	}
	
	/**
	 * Integration Test
	 */
	@Test//(expected = IllegalArgumentException.class)
	public void testCalcularICPwithDefeitoRule10() {
		
		 //get segmento, teste reverso apos feito o levantamento de campo
		final QGiSEntity gisRow = this.gisdao.findRowBy(new String[] {"objectid","4"});
		
		//get template
		template = new Template();
		
		//set Via
		final SeguimentoVia segmento = new SeguimentoVia();
		segmento.setCode(gisRow.cod_sigem);
		segmento.setComprimentoValue(gisRow.compriment);
		segmento.setLarguraValue(gisRow.largura_m);
		
		//TODO: ICP must be calculated and be setted to segmeno object
		
		//set segmento into template
		template.setVia(segmento);
		
		//get standard defects from template [1..15]
		final DefeitoType def01 = template.getMapDef().get("DEF1");
		final DefeitoType def02 = template.getMapDef().get("DEF2");
		final DefeitoType def03 = template.getMapDef().get("DEF3");
		final DefeitoType def04 = template.getMapDef().get("DEF4");
		final DefeitoType def05 = template.getMapDef().get("DEF5");
		final DefeitoType def06 = template.getMapDef().get("DEF6");
		final DefeitoType def07 = template.getMapDef().get("DEF7");
		final DefeitoType def08 = template.getMapDef().get("DEF8");
		final DefeitoType def09 = template.getMapDef().get("DEF9");
		final DefeitoType def10 = template.getMapDef().get("DEF10");
		final DefeitoType def11 = template.getMapDef().get("DEF11");
		final DefeitoType def12 = template.getMapDef().get("DEF12");
		final DefeitoType def13 = template.getMapDef().get("DEF13");
		final DefeitoType def14 = template.getMapDef().get("DEF14");
		final DefeitoType def15 = template.getMapDef().get("DEF15");
		
		//setting Random values to 
		def01.setIndiceDedutivoValue(def01.getIndiceDedutivoValue());
		def02.setIndiceDedutivoValue(def02.getIndiceDedutivoValue());
		def03.setIndiceDedutivoValue(def03.getIndiceDedutivoValue());
		def04.setIndiceDedutivoValue(def04.getIndiceDedutivoValue());
		def05.setIndiceDedutivoValue(def05.getIndiceDedutivoValue());
		def06.setIndiceDedutivoValue(def06.getIndiceDedutivoValue());
		def07.setIndiceDedutivoValue(def07.getIndiceDedutivoValue());
		def08.setIndiceDedutivoValue(def08.getIndiceDedutivoValue());
		def09.setIndiceDedutivoValue(def09.getIndiceDedutivoValue());
		def10.setIndiceDedutivoValue(def10.getIndiceDedutivoValue());
		def11.setIndiceDedutivoValue(def11.getIndiceDedutivoValue());
		def12.setIndiceDedutivoValue(def12.getIndiceDedutivoValue());
		def13.setIndiceDedutivoValue(def13.getIndiceDedutivoValue());
		def14.setIndiceDedutivoValue(def14.getIndiceDedutivoValue());
		def15.setIndiceDedutivoValue(def15.getIndiceDedutivoValue());
		
		//get defeitoType into template
		//final DefeitoType defType = new DefeitoType(null);
		
		assertEquals(def01.getCode(),template.getMapDef().get(def01.getCode()).getCode());
		
		//calculate icpRule10
	    //final Long icp = rules.executeRule10(null,null);
	
	}

}
