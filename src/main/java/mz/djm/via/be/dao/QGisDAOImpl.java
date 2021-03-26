package mz.djm.via.be.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import mz.djm.via.be.datasource.QGisDatasource;
import mz.djm.via.fe.entity.BaseObject;

public class QGisDAOImpl<T extends BaseObject> implements QGisDAO<T>{

	private JdbcTemplate jdbc;  
	private QGisDatasource datasource;
		
	protected QGisDAOImpl() throws IOException {
		
		Resource resource = new ClassPathResource("dados23032021.sqlite");			
		
		this.datasource = new QGisDatasource(resource);
	     
	    	   this.jdbc = new JdbcTemplate(datasource);

	
	}
	
	
	public static QGisDAOImpl getInstance() throws IOException {
		
		return new QGisDAOImpl();
	}
	

	@Override
	public void addRow(T t) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public  void updateRowById(Object... filter) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * filter[0] - belongs to sqlquery
	 * filter[1] - belongs to parameter filter
	 */
	@Override
	public  T findRowBy(RowMapper<T> mapper, Object... filter) {
				
		return (T) this.jdbc.query(filter[0].toString(), new String[] {filter[1].toString()}, mapper).get(0);
	}


	@Override
	public List<T> getRowsBy(Object sql, RowMapper<T> mapper) {
		
		return this.jdbc.query(new String(sql.toString()), mapper);
		
	}
	
}
