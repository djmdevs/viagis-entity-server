package mz.djm.via.be.datasource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.springframework.core.io.Resource;
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
public final class QGisDatasource extends SQLiteConnectionPoolDataSource {
	
	private SQLiteDataSource sqlDS;
	private String dbName;
	
	//one with dbName only
	private QGisDatasource(String dbName) {

		this.dbName = dbName;
		
		try {
		
			this.sqlDS = new SQLiteConnectionPoolDataSource();
			this.sqlDS.setUrl("jdbc:sqlite:".concat(this.dbName));
			
		}catch (Exception e) {
			// TODO: implementar loggers
			Logger.getGlobal().warning(e.getLocalizedMessage());
		}
		
	}
	
	//other with dbPath and dbName
	@Deprecated
    private QGisDatasource(String dbPath, String dbName) {
	
		this(dbPath.concat(dbName));
		
	}
	
	public QGisDatasource(Resource resource) throws IOException {
		
		this(resource.getFile().getPath());
		
	}
	
	@Override
	public Connection getConnection() throws SQLException {
	
		return this.sqlDS.getConnection("test", "test123");
	
	}
	
	public SQLiteDataSource getDatasource() {
		
		return this.sqlDS;
	}
	
	/*
	public Connection getSpatialConnection() throws SQLException {
		
		return this.sqlDS.getConnection("test", "test123");
	}*/
	
	/**
	 * Use SpringJBDCTemplate for simple implementation
	 * @param query
	 * @return A rersultSet with cursor dataselection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	/*
	public ResultSet executeQuery(String query) throws ClassNotFoundException, SQLException {
		
		//set driver
		Class.forName("org.sqlite.JDBC");
		
		//get config parameter
		SQLiteConfig config = new SQLiteConfig();
		
		Connection connection = this.getSpatialConnection();
		
		//transform config to properties
		config.toProperties();
		
		//create statement
		PreparedStatement stmt= connection.prepareStatement(query);
		
		return (ResultSet) stmt.executeQuery();
		
		
		
	}*/
	
	
}
