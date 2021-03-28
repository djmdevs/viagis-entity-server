package mz.djm.via.be.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import mz.djm.via.be.entity.QGiSEntity;

/**
 * Classe que permiter fazer o mapeamento
 * de todas a linhas de resgito da base QGIS
 * 
 * @author Sergio
 *
 */
public class QGisEntityDAOImpl extends QGisDAOImpl<QGiSEntity> implements QGisEntityDAO {

	protected QGisEntityDAOImpl() throws IOException {
		
		super();
	}
	
	public static  QGisEntityDAOImpl getInstance() throws IOException {
		
		return new QGisEntityDAOImpl();
	}

	/**
	 * filter[0] - belongs to customized filter field
	 * filter[1] - belongs to field value
	 */
	@Override
	public QGiSEntity findRowBy(Object... filter) {
		
		return super.findRowBy(new QGisEntityMapper(), 
				
				new String[] {"SELECT * FROM dados23032021 seg WHERE seg.".concat(filter[0].toString())+"=?;",
						filter[1].toString()
				});
	}
	
	@Override
	public List<QGiSEntity> getRows() {
		
		return super.getRowsBy("SELECT * FROM dados23032021;", new QGisEntityMapper());
	}
	
	
	@Override
	public int updateRowById(Object sql, Object... filter) {
		// TODO Auto-generated method stub
		return -1;
	}
	
	//nested Class
	public static class QGisEntityMapper implements RowMapper<QGiSEntity> {
				
				@Override
				public QGiSEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					QGiSEntity gis = new QGiSEntity();
					
					gis.objectid			=rs.getLong("objectid");//" NUMERIC(10,0);
					gis.cod_sigem			=rs.getString("cod_sigem");//" VARCHAR(36);
					gis.nvia				=rs.getString("nvia");//" VARCHAR(11);
					gis.tipovia				=rs.getString("tipovia");//" VARCHAR(50);
					gis.toponimo			=rs.getString("toponimo");//" VARCHAR(150);
					gis.distmunici			=rs.getString("distmunici");//" VARCHAR(50);
					gis.senderecam			=rs.getString("senderecam");//" VARCHAR(1);
					gis.hierarquia			=rs.getString("hierarquia");//" VARCHAR(2);
					gis.compriment			=rs.getDouble("compriment");//" NUMERIC(19,11);
					gis.largura_m			=rs.getDouble("largura_m");//" NUMERIC(19,11);
					gis.obs					=rs.getString("obs");//" VARCHAR(254);
					gis.shape_fid			=rs.getDouble("shape_fid");//" NUMERIC(10,0);
					gis.shape_leng			=rs.getString("shape_leng");//" NUMERIC(19,11);
					gis.shape_stle			=rs.getString("shape_stle");//" NUMERIC(19,11);
					gis.icp_value			=rs.getDouble("icp_value");//" NUMERIC(10,0);
					gis.intervencao_type 	=rs.getString("intervencao_type");//" VARCHAR(30);
					gis.icp_pos_value	 	=rs.getDouble("icp_pos_value");//" NUMERIC(10,0);
					gis.volume_transito  	=rs.getDouble("volume_transito");//" NUMERIC(10,0);
					gis.custo_seguimento 	=rs.getDouble("custo_seguimento");//" NUMERIC(11,3);
					gis.criterio01_value 	=rs.getDouble("criterio01_value");//" NUMERIC(10,0);
					gis.prioridade01_value 	=rs.getDouble("prioridade01_value");//" NUMERIC(11,3);
					gis.psi_value		   	=rs.getDouble("psi_value");//" NUMERIC(11,3);
					gis.criterio02_value   	=rs.getDouble("criterio02_value");//" NUMERIC(11,3);
					gis.priodade02_value	=rs.getDouble("priodade02_value");//" NUMERIC(11,3);
					gis.criterio03_value	=rs.getDouble("criterio03_value");//" NUMERIC(11,3);
					gis.prioridade03_value	=rs.getDouble("prioridade03_value");//" NUMERIC(11,3);
					gis.criterio04_value	=rs.getDouble("criterio04_value");//" NUMERIC(11,3);
					gis.prioridade04_value	=rs.getDouble("prioridade04_value");//" NUMERIC(11,3);
					gis.criterio05_value	=rs.getDouble("criterio05_value");//" NUMERIC(11,3);
					gis.prioridade05_value	=rs.getDouble("prioridade05_value");//" NUMERIC(11,3);
					gis.criterio06_value	=rs.getDouble("criterio06_value");//" NUMERIC(11,3);
					gis.prioridade06_value	=rs.getDouble("prioridade06_value");//" NUMERIC(11,3);
					gis.criterio07_value	=rs.getDouble("criterio07_value");//" NUMERIC(11,3);
					gis.prioridade07_value	=rs.getDouble("prioridade07_value");//" NUMERIC(11,3);
					gis.prioridade08_value	=rs.getDouble("prioridade08_value");//" NUMERIC(11,3);
					gis.criterio09_value	=rs.getDouble("criterio09_value");//" NUMERIC(11,3);
					gis.prioridade09_value	=rs.getDouble("prioridade09_value");//" NUMERIC(11,3);
					gis.prioridade_value	=rs.getDouble("prioridade_value");//" NUMERIC(11,3);
					gis.prioridade_status	=rs.getDouble("prioridade_status");//" VARCHAR(50);
					
					return gis;
				}
				
	}
		
}
