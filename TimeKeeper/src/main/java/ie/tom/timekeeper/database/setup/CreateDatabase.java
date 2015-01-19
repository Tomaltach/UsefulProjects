package ie.tom.timekeeper.database.setup;

import ie.tom.timekeeper.Resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateDatabase {
	private Connection conn = null;
	private Statement stmt = null;

	public void createDatabase() {
		try { 
			Class.forName(Resources.JDBC_DRIVER);
			
			conn = DriverManager.getConnection(Resources.DB_URL, Resources.USER, Resources.PASS);
			stmt = conn.createStatement();
			stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS cardio_records");
		} catch (SQLException ex) {
			Logger.getLogger(CreateDatabase.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) {
					stmt.close();
				}
			} catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}    
}