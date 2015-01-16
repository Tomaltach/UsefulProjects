package ie.tom.timekeeper.database.setup;

import ie.tom.timekeeper.Resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableRecord implements CreateTable {
    
	public void createTable() {
		Connection conn = null;
		Statement stmt = null;
		try {
			//STEP 1: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			//STEP 2: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(Resources.DB_URL, Resources.USER, Resources.PASS);
			System.out.println("Connected database successfully...");

			//STEP 3: Execute a query
			System.out.println("Creating table in given database...");
			stmt = conn.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS records " +
					"(id INTEGER not NULL AUTO_INCREMENT, " +
					" date DATE not NULL, " + 
					" time VARCHAR(50) not NULL, " + 
					" distance DOUBLE not NULL, " + 
					" type VARCHAR(25) not NULL, " + 
					" unit VARCHAR(15) not NULL, " + 
					" PRIMARY KEY ( id ))"; 

			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
		} catch(SQLException se) {
			se.printStackTrace();
		} catch(Exception e) {
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