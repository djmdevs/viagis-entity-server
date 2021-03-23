package mz.djm.via.be.dao;

import mz.djm.via.fe.entity.BaseObject;
import mz.djm.via.fe.entity.IntervencaoType;
import mz.djm.via.fe.entity.Template;

public interface QGisEntityDAO {

	/**
	 * Add template values into vias_tbls
	 * @param templ
	 */
	public void addRow(Template templ);
	
	/**
	 * Update values into vias_tbls
	 * @param id
	 */
	public void updateRowById(Long id);
	
	
	/**
	 * 
	 */
	public <T extends BaseObject> T findRowById(Long id);
	
	/**
	 * 
	 * @param <T>
	 * @return
	 */
	public <T extends BaseObject> T listRowsByCode(String filter);

}
