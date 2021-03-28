package mz.djm.via.be.rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.jdbc.UncategorizedSQLException;

import mz.djm.via.be.dao.QGisEntityDAO;
import mz.djm.via.be.dao.QGisEntityDAOImpl;
import mz.djm.via.be.entity.QGiSEntity;
import mz.djm.via.fe.entity.Criterio;
import mz.djm.via.fe.entity.DefeitoType;
import mz.djm.via.fe.entity.IntervencaoType;
import mz.djm.via.fe.entity.SeguimentoVia;
import mz.djm.via.fe.entity.Template;
import mz.djm.via.fe.entity.subs.Criterio01;
import mz.djm.via.fe.entity.subs.Criterio06;


public class CriterioRuleTest{

	private QGisEntityDAO gisdao;
	private IRule rules;
	
	
	@Before
	public void setUp() throws Exception {
		
		gisdao = QGisEntityDAOImpl.getInstance();
		rules  = new CriterioRule();
	}

	@Test(expected = UncategorizedSQLException.class)
	public void testCheckIfParameterExists() {
		
		final String[] parameter = {"objectid","1"};
		
		//get segmento
		final QGiSEntity gisRow = this.gisdao.findRowBy(parameter);
		
		assertEquals("1", gisRow.objectid);
	}
	
	/**
	 * Testing updating row into database
	 */
	@Test
	public void testUpdateRowIntoDatabase() {
		
		final QGiSEntity gisRow = this.gisdao.findRowBy(new String[] {"objectid","100"});
		
		int isUpdatedRow = this.gisdao.updateRowById("",
				new String[] {"objectid"			,"3000"},
	    		new String[] {"icp_value"			,"87"},
	    		new String[] {"intervencao_type"	,"NADA A FAZER"},
	    		new String[] {"icp_pos_value"		,"30"},
	    		new String[] {"custo_seguimento"	,"23000.56"},
	    		new String[] {"criterio01_value"	,"50"}
				);
		
		assertTrue(isUpdatedRow>0? "Row Updated": "Row Not Updated", isUpdatedRow>0);
	    
	}
	
	/**
	 * Integration Test
	 */
	@Test//(expected = IllegalArgumentException.class)
	public void testCalcularICPwithDefeitoRule10() {
		
		 //get segmento, teste reverso apos feito o levantamento de campo
		final QGiSEntity gisRow = this.gisdao.findRowBy(new String[] {"objectid","4"});
		
		//get template
		final Template template = new Template();
		
		//set Via
		final SeguimentoVia seg04 = new SeguimentoVia();
		seg04.setCode(gisRow.cod_sigem);
		seg04.setComprimentoValue(gisRow.compriment);
		seg04.setLarguraValue(gisRow.largura_m);
		seg04.setLatitude(gisRow.shape_leng);
		seg04.setLongitude(gisRow.shape_stle);
		
		/*
		atribuicao do um valor aleatorio volume de transito
		gisRow.volume_transito = new Random().nextDouble();
		*/
		gisRow.volume_transito = 58d;
		
		//pega volume de transito
		seg04.setTransitoValue(gisRow.volume_transito);

		//set segmento into template
		template.setVia(seg04);
		
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
		def01.setIndiceDedutivoValue(8);
		def02.setIndiceDedutivoValue(4);
		def03.setIndiceDedutivoValue(10);
		def04.setIndiceDedutivoValue(2);
		def05.setIndiceDedutivoValue(7);
		def06.setIndiceDedutivoValue(5);
		def07.setIndiceDedutivoValue(9);
		def08.setIndiceDedutivoValue(3);
		def09.setIndiceDedutivoValue(8);
		def10.setIndiceDedutivoValue(5);
		def11.setIndiceDedutivoValue(8);
		def12.setIndiceDedutivoValue(7);
		def13.setIndiceDedutivoValue(2);
		def14.setIndiceDedutivoValue(1);
		def15.setIndiceDedutivoValue(10);
			
		//assertEquals(def01.getIndiceDedutivoValue(),template.getMapDef().get(def01.getCode()).getIndiceDedutivoValue());
		
		//associa os defeitos ao Template
		template.getMapDef().replace(def01.getCode(), def01);
		template.getMapDef().replace(def02.getCode(), def02);
		template.getMapDef().replace(def03.getCode(), def03);
		template.getMapDef().replace(def04.getCode(), def04);
		template.getMapDef().replace(def05.getCode(), def05);
		template.getMapDef().replace(def06.getCode(), def06);
		template.getMapDef().replace(def07.getCode(), def07);
		template.getMapDef().replace(def08.getCode(), def08);
		template.getMapDef().replace(def09.getCode(), def09);
		template.getMapDef().replace(def10.getCode(), def10);
		template.getMapDef().replace(def11.getCode(), def11);
		template.getMapDef().replace(def12.getCode(), def12);
		template.getMapDef().replace(def13.getCode(), def13);
		template.getMapDef().replace(def14.getCode(), def14);
		template.getMapDef().replace(def15.getCode(), def15);
		
		//calculate rule10
	    final Long icp = rules.executeRule10(template.getMapDef());
	    assertEquals(11, icp.longValue());
	    
	    //calculate rule20
	    final IntervencaoType intervencaoSemCustoGlobal = rules.executeRule20(icp);
	    intervencaoSemCustoGlobal.setVia(seg04);
	    assertEquals("RECONSTRUÇÃO", intervencaoSemCustoGlobal.getDescription());
	    
	    //calculate rule30
	    final IntervencaoType intervencaoComCustoGlobal = rules.executeRule30(intervencaoSemCustoGlobal);
	    assertEquals(1742900.0d, intervencaoComCustoGlobal.getCustoValue().doubleValue(),1);
	    
	    //calculate rule40
	    assertEquals(58d, seg04.getVolumeTransitoValue(),1);
	    
	    final Criterio01 criterio01 = new Criterio01(seg04.getVolumeTransitoValue());
	    criterio01.setValue(rules.executeRule40(criterio01));
	    assertEquals(0.0028951747088186352d, criterio01.getValue(),1);
	    
	    final Criterio06 criterio06 = new Criterio06();
	    criterio06.setValue(rules.executeRule40(criterio06));
	    assertEquals(86721.6d, criterio06.getValue(),1);
	  
	    /*
	     * Escrever na base QGis da entidade todos os dados
	     */
	    gisRow.objectid				=gisRow.objectid;
	    gisRow.icp_value			=icp.doubleValue();
		gisRow.intervencao_type 	=intervencaoComCustoGlobal.getDescription();
		gisRow.icp_pos_value	 	=intervencaoComCustoGlobal.getICPposIntervencao().doubleValue();
		gisRow.volume_transito  	=intervencaoComCustoGlobal.getVia().getVolumeTransitoValue();
		gisRow.custo_seguimento 	=intervencaoComCustoGlobal.getCustoValue();
		gisRow.criterio01_value 	=criterio01.getValue();
		//gisRow.prioridade01_value 	=criterio01.getPriorityValue();
		//gisRow.psi_value		   	=rs.getDouble("psi_value");//" NUMERIC(11,3);
		//gisRow.criterio02_value   	=rs.getDouble("criterio02_value");//" NUMERIC(11,3);
		//gisRow.priodade02_value	=rs.getDouble("priodade02_value");//" NUMERIC(11,3);
		//gisRow.criterio03_value	=rs.getDouble("criterio03_value");//" NUMERIC(11,3);
		//gisRow.prioridade03_value	=rs.getDouble("prioridade03_value");//" NUMERIC(11,3);
		//gisRow.criterio04_value	=rs.getDouble("criterio04_value");//" NUMERIC(11,3);
		//gisRow.prioridade04_value	=rs.getDouble("prioridade04_value");//" NUMERIC(11,3);
		//gisRow.criterio05_value	=rs.getDouble("criterio05_value");//" NUMERIC(11,3);
		//gisRow.prioridade05_value	=rs.getDouble("prioridade05_value");//" NUMERIC(11,3);
		//gisRow.criterio06_value		=criterio06.getValue();
		//gisRow.prioridade06_value	=criterio06.getPriorityValue();
		//gisRow.criterio07_value	=rs.getDouble("criterio07_value");//" NUMERIC(11,3);
		//gisRow.prioridade07_value	=rs.getDouble("prioridade07_value");//" NUMERIC(11,3);
		//gisRow.prioridade08_value	=rs.getDouble("prioridade08_value");//" NUMERIC(11,3);
		//gisRow.criterio09_value	=rs.getDouble("criterio09_value");//" NUMERIC(11,3);
		//gisRow.prioridade09_value	=rs.getDouble("prioridade09_value");//" NUMERIC(11,3);
		//gisRow.prioridade_value	=rs.getDouble("prioridade_value");//" NUMERIC(11,3);
		//gisRow.prioridade_status	=rs.getDouble("prioridade_status");//" VARCHAR(50);
	    		
	    this.gisdao.updateRowById(new String[] {"objectid","4"},
	    		new String[] {"objectid","4"},
	    		new String[] {"objectid","4"},
	    		new String[] {"objectid","4"},
	    		new String[] {"objectid","4"},
	    		new String[] {"objectid","4"});
	    
	    /*definindo a prioridade do criterio calcula apos o lancamento dos dados
	    * na base QGis
	    */
	    //rules.executeRule50(criterio01);
	    
	    
	
	}
	
	/**
	 * Do not use this test 
	 */
	@Deprecated
	@Ignore
	@Test//(expected = IllegalArgumentException.class)
	public void testExecutarRule10And20And30And40And50() {
		
		 //get segmento, teste reverso apos feito o levantamento de campo
		final QGiSEntity gisRow = this.gisdao.findRowBy(new String[] {"objectid","4"});
			
		//set Via
		final SeguimentoVia segmento = new SeguimentoVia();
		segmento.setCode(gisRow.cod_sigem);
		segmento.setComprimentoValue(gisRow.compriment);
		segmento.setLarguraValue(gisRow.largura_m);
		segmento.setLatitude(gisRow.shape_leng);
		segmento.setLongitude(gisRow.shape_stle);
		
		//get template /simula o mobile
		final Template template = new Template();
		
		//set segmento into template
		template.setVia(segmento);
				
		//Automatizing Random set Defects
		final DefeitoType[] defArr = new DefeitoType[template.getMapDef().values().size()];
		int i = defArr.length-1;
		
		//transport to DefeitoType as an Attribute
		for(DefeitoType def: template.getMapDef().values()) {
					
				template.getMapDef().replace(def.getCode(), def);
				defArr[i--]= def;
		}
						
		assertEquals(new Long(15).longValue(),defArr.length);
		
		/*
		 * ExecuteRule10
		 */
		final Long icp = rules.executeRule10(template.getMapDef());
		
		assertNotEquals(8, icp.longValue());
		
		/*
		 * ExecuteRule20
		 */
		final IntervencaoType intervencaoWithoutCusto = rules.executeRule20(icp);
		intervencaoWithoutCusto.setVia(segmento);
		
		//check intervencao atributes
		assertNotEquals(0, intervencaoWithoutCusto.getcO2Metro2(), 1);
		assertNotEquals("MT", intervencaoWithoutCusto.getCode());
		assertNull("O custo de intervenção é Nulo", intervencaoWithoutCusto.getCustoValue());
		assertNotEquals("XXXXX", intervencaoWithoutCusto.getVia().getCode());
		
		//check if Segmento has icp
		assertNotEquals(new Long(2), segmento.getIcpValue());
		
		/*
		 * ExecuteRule30
		 */
		final IntervencaoType intervencaoWithCusto = rules.executeRule30(intervencaoWithoutCusto);
		assertNotNull("O custo de intervenção já não é Nulo", intervencaoWithCusto.getCustoValue());
		
		/*
		 * ExecuteRule40
		 */
		final Criterio criterio01 = new Criterio01(rules.executeRule40(new Criterio01()));
		assertNotEquals(1D, criterio01.getValue(), 1);
		
		final Criterio criterio06 = new Criterio06(rules.executeRule40(new Criterio06()));
		assertNotEquals(6D, criterio06.getValue(), 1);
		
		/*
		 * ExecuteRule50
		 */
				
				
		/*
		 * Actualiza os dados da linha 4 do QGis no objecto QGisEntity
		 */
		
		
		
	}

}
