package mz.djm.via.be.rule;

import java.util.Map;

import mz.djm.via.fe.entity.Criterio;
import mz.djm.via.fe.entity.DefeitoType;
import mz.djm.via.fe.entity.IntervencaoType;

/**
 * Define todas as regras de negocio a serem
 * implementadas pelos respectivos criterios
 * @author Sergio
 * 
 * Implementar Builder in Future
 *
 */
public interface IRule {
	
	/**
	 * Calcula o índice de pavimento (icp)	
	 * @return
	 */
	public Long executeRule10(DefeitoType[] defeitos, Integer totalDefeitos);
	
	
	public Long executeRule10(Map mapDef);
	
	
	/**
	 * Executa a regra de calculo do tipo de intervenção 
	 * e contem o custo por metro quadrado definido em função do tipo de intevenção
	 * @param icpValue
	 * @return
	 */
	public IntervencaoType executeRule20(Long icpValue);
	
	
	/**
	 * Calcula o custo de intervencao para o seguimento pela expressao 
	 * @return
	 */
	public IntervencaoType executeRule30(IntervencaoType intervencaoObject);
	
	/**
	 * Avalia alternativas de classificação 
	 * e atribui a pontuação ponderada ao seguimento com base na analise multicritério.
	 * retorna o indice de prioridade
	 */
	public Double executeRule40(Criterio criterio);
	
	/**
	 * Calcula a prioridade dos segmentos por intervencao com base nos criterios
	 * de avaliacao
	 * @param criterio
	 * @return
	 */
	public Double executeRule50(Criterio criterio);
	
	
	

}
