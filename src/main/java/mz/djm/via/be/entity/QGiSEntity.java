package mz.djm.via.be.entity;

import mz.djm.via.fe.entity.BaseObject;

/**
 * 
 * @author Sergio
 *
 */
public class QGiSEntity extends BaseObject{

	 public Long objectid;//" NUMERIC(10,0);
	 public String cod_sigem;//" VARCHAR(36);
	 public String nvia;//" VARCHAR(11);
	 public String tipovia;//" VARCHAR(50);
	 public String toponimo;//" VARCHAR(150);
	 public String distmunici;//" VARCHAR(50);
	 public String senderecam;//" VARCHAR(1);
	 public String hierarquia;//" VARCHAR(2);
	 public Double compriment;//" NUMERIC(19,11);
	 public Double largura_m;//" NUMERIC(19,11);
	 public String obs;//" VARCHAR(254);
	 public Double shape_fid;//" NUMERIC(10,0);
	 public String shape_leng;//" NUMERIC(19,11);
	 public String shape_stle;//" NUMERIC(19,11);
	 public Double icp_value;//" NUMERIC(10,0);
	 public String intervencao_type;//" VARCHAR(30);
	 public Double icp_pos_value;//" NUMERIC(10,0);
	 public Double volume_transito;//" NUMERIC(10,0);
	 public Double custo_seguimento;//" NUMERIC(11,3);
	 public Double criterio01_value;//" NUMERIC(10,0);
	 public Double prioridade01_value;//" NUMERIC(11,3);
	 public Double psi_value;//" NUMERIC(11,3);
	 public Double criterio02_value;//" NUMERIC(11,3);
	 public Double priodade02_value;//" NUMERIC(11,3);
	 public Double criterio03_value;//" NUMERIC(11,3);
	 public Double prioridade03_value;//" NUMERIC(11,3);
	 public Double criterio04_value;//" NUMERIC(11,3);
	 public Double prioridade04_value;//" NUMERIC(11,3);
	 public Double criterio05_value;//" NUMERIC(11,3);
	 public Double prioridade05_value;//" NUMERIC(11,3);
	 public Double criterio06_value;//" NUMERIC(11,3);
	 public Double prioridade06_value;//" NUMERIC(11,3);
	 public Double criterio07_value;//" NUMERIC(11,3);
	 public Double prioridade07_value;//" NUMERIC(11,3);
	 public Double prioridade08_value;//" NUMERIC(11,3);
	 public Double criterio09_value;//" NUMERIC(11,3);
	 public Double prioridade09_value;//" NUMERIC(11,3);
	 public Double prioridade_value;//" NUMERIC(11,3);
	 public Double prioridade_status;//" VARCHAR(50);
	 
	 public QGiSEntity() {
		// TODO Auto-generated constructor stub
	}
}
