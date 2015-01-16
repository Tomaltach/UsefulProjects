package ie.tom.timekeeper.database.handlers;

import ie.tom.timekeeper.Resources;
import ie.tom.timekeeper.entity.Record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDatabaseImpl implements UpdateDatabase {
	private Connection con;
	private Statement stmt;
	
	@Override
	public void insertRecord(final Record record) {
		try {
			Class.forName(Resources.JDBC_DRIVER).newInstance();
			con = DriverManager.getConnection(Resources.DB_URL, Resources.USER, Resources.PASS);			
			stmt = con.createStatement();
			
			String insert = "";
			PreparedStatement ps = con.prepareStatement(
				"INSERT INTO records(" +
					"date, " +
					"time, " +
					"distance, " +
					"type, " +
					"unit" +
				") " +
				"VALUES(?,?,?,?,?)"
			);
			ps.setDate(1, record.getDate());
			ps.setString(2, record.getTime());
			ps.setDouble(3, record.getDistance());
			ps.setString(4, record.getType());
			ps.setString(5, record.getUnit());
			
			stmt.execute(insert);
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
				if(con!=null) {
					con.close();
				}
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
	@Override
	public void updateRecord(Record record) {
				
	}
}