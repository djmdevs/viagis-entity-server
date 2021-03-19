package mz.djm.via.be.rule;

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
	public Long executeRule10(DefeitoType[] defeitos, int totalDefeitos);
	
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
	 * Avalia os criterios de classificação 
	 * e atribui a pontuação ponderada ao seguimento com base na analise multicritério.
	 */
	public Double executeRule40(Criterio criterio);
	
	

}
