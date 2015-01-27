package ie.tom.timekeeper.database.setup;

import ie.tom.timekeeper.Resources;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetupDatabase {

	public SetupDatabase() {
		//buildDatabase();
		//buildMysqlTable();
		buildDerbyTable();
	}
	@SuppressWarnings("unused")
	private void buildDatabase() {
		CreateDatabase database = new CreateDatabase();
		database.createDatabase();
	}
	@SuppressWarnings("unused")
	private void buildMysqlTable() {
		CreateTable record = new CreateTableRecord();
		record.createTable();
	}
	private void buildDerbyTable() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(Resources.DERBY_DRIVER);
			DatabaseMetaData dbmd = con.getMetaData();
			ResultSet rs = dbmd.getTables(null, "ROOT", "records", null);
			if(!rs.next()) {
				CreateTable record = new CreateTableRecord();
				record.createDerbyTable();
			}
		} catch(SQLException e) {
			
		} finally {
			try {
				if(con!=null) {
					con.close();
				}
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
}