package mz.djm.via.be.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import mz.djm.via.be.datasource.EntityDatasource;
import mz.djm.via.fe.entity.BaseObject;
import mz.djm.via.fe.entity.IntervencaoType;
import mz.djm.via.fe.entity.Template;

public class QGisEntityDAOImpl implements QGisEntityDAO{

	private JdbcTemplate template;  
	private EntityDatasource datasource;
	
	public QGisEntityDAOImpl() {
	     
		this.datasource = new EntityDatasource("spatial-test-db.sqlite");
	     
	    template =new JdbcTemplate(datasource);
	}
	
	@Override
	public void addRow(Template templ) {
		
		// TODO: 
		
	}

	@Override
	public void updateRowById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends BaseObject> T findRowById(Long id) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public <T extends BaseObject> T listRowsByCode(String filter) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM vias_tbl;";
		
		this.template.query(sql, new IntervencaoTypeMapper());
	
		return null;
	}
	
	
	private class IntervencaoTypeMapper implements RowMapper<IntervencaoType>{

		@Override
		public IntervencaoType mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			IntervencaoType iType = new IntervencaoType();
			
			//iType.se
			return iType;
		}
		
		
	}

}
