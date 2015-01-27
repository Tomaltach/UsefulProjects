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
			Class.forName(Resources.JDBC_DRIVER);

			//STEP 2: Open a connection
			conn = DriverManager.getConnection(Resources.DB_URL, Resources.USER, Resources.PASS);

			//STEP 3: Execute a query
			stmt = conn.createStatement();

			String sql = "CREATE TABLE records " +
					"(id INTEGER NOT NULL AUTO_INCREMENT, " +
					" date DATE NOT NULL, " + 
					" time VARCHAR(50) NOT NULL, " + 
					" distance DOUBLE NOT NULL, " + 
					" type VARCHAR(25) NOT NULL, " + 
					" unit VARCHAR(15) NOT NULL, " + 
					" PRIMARY KEY ( id ))"; 

			stmt.executeUpdate(sql);
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
	public void createDerbyTable() {
		Connection conn = null;
		Statement stmt = null;
		try {
			//STEP 1: Register JDBC driver
			Class.forName(Resources.JDBC_DRIVER);

			//STEP 2: Open a connection
			conn = DriverManager.getConnection(Resources.DB_URL, Resources.USER, Resources.PASS);

			//STEP 3: Execute a query
			stmt = conn.createStatement();

			String sql = "CREATE TABLE records " +
					"(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
					" date DATE NOT NULL, " + 
					" time VARCHAR(50) NOT NULL, " + 
					" distance DOUBLE NOT NULL, " + 
					" type VARCHAR(25) NOT NULL, " + 
					" unit VARCHAR(15) NOT NULL, " + 
					" CONSTRAINT primary_key PRIMARY KEY ( id ))"; 

			stmt.executeUpdate(sql);
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