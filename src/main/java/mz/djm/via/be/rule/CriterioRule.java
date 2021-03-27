package mz.djm.via.be.rule;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collection;
import java.util.Map;

import mz.djm.via.be.dao.QGisEntityDAO;
import mz.djm.via.be.dao.QGisEntityDAOImpl;
import mz.djm.via.be.entity.QGiSEntity;
import mz.djm.via.fe.entity.Criterio;
import mz.djm.via.fe.entity.DefeitoType;
import mz.djm.via.fe.entity.IntervencaoType;
import mz.djm.via.fe.entity.subs.Criterio01;
import mz.djm.via.fe.entity.subs.Criterio06;

/**
 * Cria as Regras para calculo dos criterios
 * 
 * @author Sergio
 *
 */
public class CriterioRule implements IRule {

	private IntervencaoType intervencao;
	private QGisEntityDAO gisdao;
	
	public CriterioRule() throws Exception {
		
		this.gisdao = QGisEntityDAOImpl.getInstance();
	
	}
	
	@Override
	public Long executeRule10(DefeitoType[] defeitos, Integer defNumbers) {

		if(defNumbers == 0)	
			return defeitos[0].getIndiceDedutivoValue().longValue(); 
			
		// it has 15 defects
		return	defeitos[defNumbers-1].getIndiceDedutivoValue().longValue() + executeRule10(defeitos,defNumbers-1);
		
	}
	
	@Override
	public Long executeRule10(Map mapDef) {
		
		Integer sum =0;
		
		for(DefeitoType each: (Collection<DefeitoType>) mapDef.values()) {
			
			sum = sum + each.getIndiceDedutivoValue();
		}
		
		return 100L - sum;
	}
	
	

	@Override
	public IntervencaoType executeRule20(Long icpValue) {
		
		IntervencaoType intervencao  = new IntervencaoType();
		
		//validate icp
		if(icpValue>74) {
			
			intervencao.setCode("NaF");
			intervencao.setDescription("NADA A FAZER");
			intervencao.setIcpPosIntervencao(icpValue);
			//intervencao.setCustoValue(custoValue);
			intervencao.setIcpValue(icpValue);
			
		}else if(icpValue>64) {
				
				intervencao.setCode("MdR");
				intervencao.setDescription("MANUTENÇÃO DE ROTINA");
				intervencao.setIcpPosIntervencao(75L);
				intervencao.setCustoMetro2(2600D);
				intervencao.setIcpValue(icpValue);
				intervencao.setcO2Metro2(76.06D);
				
		}else if(icpValue>54) {
					
				intervencao.setCode("MaP");
				intervencao.setIcpPosIntervencao(90L);
				intervencao.setDescription("MANUTENÇÃO PERIÓDICA");
				intervencao.setCustoMetro2(3200D);
				intervencao.setIcpValue(icpValue);
				intervencao.setcO2Metro2(224.41D);
				
		}else if(icpValue>39) {
			
				intervencao.setCode("RaB");
				intervencao.setIcpPosIntervencao(95L);
				intervencao.setDescription("REABILITAÇÃO");
				intervencao.setCustoMetro2(5200D);
				intervencao.setIcpValue(icpValue);
				intervencao.setcO2Metro2(231.87D);
		
		}else {
				intervencao.setCode("RcT");
				intervencao.setIcpPosIntervencao(98L);
				intervencao.setDescription("RECONSTRUÇÃO");
				intervencao.setCustoMetro2(6010D);
				intervencao.setIcpValue(icpValue);
				intervencao.setcO2Metro2(299.04D);
		}
		
		//clone
		this.intervencao = intervencao;
		
		return this.intervencao;
	}

	@Override
	public IntervencaoType executeRule30(IntervencaoType intervencaoObject) {
		
		this.intervencao = intervencaoObject;
		
		BigDecimal rule30 = new BigDecimal(intervencaoObject.getCustoMetro2());
		
		rule30.multiply(new BigDecimal(intervencaoObject.getVia().getComprimentoValue()));
		rule30.multiply(new BigDecimal(intervencaoObject.getVia().getLarguraValue()));
		
		//define the hole necessary BUDGET
		intervencaoObject.setCustoValue(rule30.doubleValue());
		
		return intervencaoObject;
	}

	@Override
	public Double executeRule40(Criterio criterio) {
		
		//polimorf
		//create factory or builder
		
		BigDecimal rule40S =null;
		
		//criterio 01 escopo
		if(criterio instanceof Criterio01) {
			
			Criterio01 c01 = (Criterio01) criterio;
			c01.setIntervecaoCost(this.intervencao.getCustoValue());
			
			//only for criteria 1
			rule40S = new BigDecimal(this.intervencao.getICPposIntervencao().doubleValue());
			
			//subtr
			rule40S.subtract(new BigDecimal(this.intervencao.getIcpValue()));
		
			//mult
			rule40S.multiply(rule40S,
					new MathContext(rule40S.divide(
							new BigDecimal(c01.getTransitoValue().intValue()), 
							new MathContext(c01.getIntervecaoCusto().toString())).toString()));
		
			
		}
		
		//criterio 06 escopo
		if(criterio instanceof Criterio06) {
			
			//add rule here
			rule40S = new BigDecimal(this.intervencao.getcO2Metro2());
			
			//math
			rule40S = rule40S.multiply(new BigDecimal(this.intervencao.getVia().getComprimentoValue()));
			rule40S = rule40S.multiply(new BigDecimal(this.intervencao.getVia().getLarguraValue()));
			
		}
		
		//TODO: add other instances if exists
		
		return rule40S.doubleValue();
	}
	
	@Override
	public Double executeRule50(Criterio criterio) {
		
		BigDecimal rule50 = null;
		
		if(criterio instanceof Criterio01) {
			
			//get criterio01 from rule40
			Criterio01 criterio01 = (Criterio01) criterio;
			
			//call list of criterio01 values
			rule50 = new BigDecimal(criterio01.getValue());
			
			rule50 = rule50.divide(rule50, new MathContext(new BigDecimal(this.getCriterioSummarizing(criterio01)).toString()));
	
		}
		
		return rule50.doubleValue();
	}
	
	/**
	 * Servico que permite sumarizar os valores dos criterios
	 * com base na regra de negocio 40
	 * @param criterio
	 * @return
	 */
	private Double getCriterioSummarizing(Criterio criterio) {
		
		Collection<QGiSEntity> gisRows = this.gisdao.getRows();
		
		double summurizedCriterio = 0;
		
		for(QGiSEntity row : gisRows) {
			
			if(criterio instanceof Criterio01) {
				
				 //For-each row execute rule40 and get the criterio1 
				 summurizedCriterio = summurizedCriterio + this.executeRule40(new Criterio01(row.criterio01_value));
			
			}
			
			if(criterio instanceof Criterio06) {
				
				 //For-each row execute rule40 and get the criterio6
				 summurizedCriterio = summurizedCriterio + this.executeRule40(new Criterio06(row.criterio06_value));
			}
		}
		
		return summurizedCriterio; 
	}
	
	public IntervencaoType getIntervencao() {
		return intervencao;
	}

}
