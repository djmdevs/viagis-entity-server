package mz.djm.via.be.dao;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import mz.djm.via.be.entity.QGiSEntity;

public interface QGisEntityDAO  extends QGisDAO<QGiSEntity> {
	
	
	public void updateRowById(Object... filter);
	
	public List<QGiSEntity> getRows();
	
	public QGiSEntity findRowBy(Object... filter);

}
