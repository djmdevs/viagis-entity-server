package mz.djm.via.be.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import org.sqlite.SQLiteConnection;
import org.sqlite.javax.SQLiteConnectionPoolDataSource;

/**
 * 
 * @author Djm Core
 *
 */


/*
* Add this implementation on gendao
*/
public class EntityDatasource extends SQLiteConnectionPoolDataSource {
	
	@Override
	public Connection getConnection() throws SQLException {
	
		return (SQLiteConnection) super.getConnection("test", "test");
	
	}
}
