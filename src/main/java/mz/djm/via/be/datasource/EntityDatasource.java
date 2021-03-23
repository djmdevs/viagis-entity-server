package mz.djm.via.be.datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;
import org.sqlite.javax.SQLiteConnectionPoolDataSource;

/**
 * 
 * @author Djm Core
 *
 */


/*
* Add this implementation on gendao
*/
public final class EntityDatasource extends SQLiteConnectionPoolDataSource {
	
	private SQLiteDataSource sqlDS;
	private String dbName;
	
	//one with dbName only
	public EntityDatasource(String dbName) {

		this.dbName = dbName;
		
		try {
		
			sqlDS = new SQLiteConnectionPoolDataSource();
			sqlDS.setUrl("jdbc:sqlite:".concat(this.dbName));
			
		}catch (Exception e) {
			// TODO: implementar loggers
			Logger.getGlobal().warning(e.getLocalizedMessage());
		}
		
		
	}
	
	//other with dbPath and dbName
	public EntityDatasource(String dbPath, String dbName) {
	
		this(dbPath.concat(dbName));
		
	
	}
	
	@Override
	public Connection getConnection() throws SQLException {
	
		return sqlDS.getConnection("test", "sqldb123");
	
	}
	
	public Connection getSpatialConnection() throws SQLException {
		
		return sqlDS.getConnection("test", "spatialdb123");
	}
	
	/**
	 * Use SpringJBDCTemplate for simple implementation
	 * @param query
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public String executeQuery(String query) throws ClassNotFoundException, SQLException {
		
		//set driver
		Class.forName("org.sqlite.JDBC");
		
		//get config parameter
		SQLiteConfig config = new SQLiteConfig();
		
		Connection connection = this.getSpatialConnection();
		
		//transform config to properties
		config.toProperties();
		
		//create statement
		Statement stmt = connection.createStatement();
		
		return stmt.executeQuery(query).toString();
		
		
		
	}
	
	public SQLiteDataSource getDatasource() {
		return sqlDS;
	}
}
