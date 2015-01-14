package ie.tom.timekeeper.database.setup;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetupDatabase {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/cardio_records";
	static final String DB_NAME = "cardio_records";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";
	private Connection conn;

	public SetupDatabase() {
		if(checkDatabaseExists() == false) {
			buildDatabase();
		} else {
			if(checkTableExists() == false) {
				buildTable();
			}
		}
		// connectDatabase();
	}
	private boolean checkDatabaseExists() {
		// TODO Auto-generated method stub
		return false;
	}
	private boolean checkTableExists() {
		try {
			DatabaseMetaData meta = conn.getMetaData();
			ResultSet res = meta.getTables(null, null, null, new String[] {DB_NAME});
			while (res.next()) {
				try {
					System.out.println(
						"   " + res.getString("TABLE_CAT") + 
						", " + res.getString("TABLE_SCHEM") +
						", " + res.getString("TABLE_NAME") +
						", " + res.getString("TABLE_TYPE") +
							", "+res.getString("REMARKS"));
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		} catch(SQLException e) {}
		return false;
	}
	private void buildDatabase() {
		CreateDatabase database = new CreateDatabase();
		database.createDatabase();
		CreateTable record = new CreateTableRecord();
		record.createTable();
	}
	private void buildTable() {
		CreateTable record = new CreateTableRecord();
		record.createTable();
	}
	@SuppressWarnings("unused")
	private void connectDatabase() {
                
	}
}