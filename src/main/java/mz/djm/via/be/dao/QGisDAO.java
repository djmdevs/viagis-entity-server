package mz.djm.via.be.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import mz.djm.via.fe.entity.BaseObject;
import mz.djm.via.fe.entity.Template;

/**
 * Migrate to GenDAO
 * @author Sergio
 *
 */
public interface QGisDAO<T extends BaseObject> {

	/**
	 * Add template values into vias_tbls
	 * @param templ
	 */
	default void addRow(T t) {
	}
	
	/**
	 * Update values into vias_tbls
	 * @param id
	 */
	public void updateRowById(Object... filter);
	
	default  void updateRowById(RowMapper<T> mapper, Object... filter) {}
	
	/**
	 * 
	 */
	public  T findRowBy(RowMapper<T> mapper,Object... filter);
	
	
	public  List<T> getRowsBy(Object query, RowMapper<T> mapper);
	
	
}


