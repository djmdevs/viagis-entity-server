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
	 * Calcula o �ndice de pavimento (icp)	
	 * @return
	 */
	public Long executeRule10(DefeitoType[] defeitos, int totalDefeitos);
	
	/**
	 * Executa a regra de calculo do tipo de interven��o 
	 * e contem o custo por metro quadrado definido em fun��o do tipo de inteven��o
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
	 * Avalia os criterios de classifica��o 
	 * e atribui a pontua��o ponderada ao seguimento com base na analise multicrit�rio.
	 */
	public Double executeRule40(Criterio criterio);
	
	

}
