package ie.tom.timekeeper.database.handlers;

import ie.tom.timekeeper.Resources;
import ie.tom.timekeeper.entity.Record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcRecordImpl implements RecordDao {
	private Connection con;
	private PreparedStatement ps;
	
	@Override
	public void insertRecord(final Record record) {
		try {
			Class.forName(Resources.JDBC_DRIVER).newInstance();
			con = DriverManager.getConnection(Resources.DB_URL, Resources.USER, Resources.PASS);			
			
			ps = con.prepareStatement(
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
			
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) {
					ps.close();
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
	public List<Record> listRecords(int month, String year, String type, String unit) {
		List<Record> records = new ArrayList<Record>();
		String sql = "SELECT * FROM records ";
		int check = 0;
		if(month != 0) {
			if(check == 0) {
				sql += "WHERE ";
			}
			check = 1;
			sql += "MONTH(date) = '" + month + "' ";
		}
		if(!year.equals("All")) {
			if(check == 0) {
				sql += "WHERE ";
			} else {
				sql += "AND ";
			}
			check = 1;
			sql += "YEAR(date) = '" + year + "' ";
		}
		if(!type.equals("All")) {
			if(check == 0) {
				sql += "WHERE ";
			} else {
				sql += "AND ";
			}
			check = 1;
			sql += "type = '" + type + "' ";
		}
		if(!unit.equals("All")) {
			if(check == 0) {
				sql += "WHERE ";
			} else {
				sql += "AND ";
			}
			check = 1;
			sql += "unit = '" + unit + "' ";
		}
		try {
			Class.forName(Resources.JDBC_DRIVER).newInstance();
			con = DriverManager.getConnection(Resources.DB_URL, Resources.USER, Resources.PASS);			
			
			ps = con.prepareStatement(sql);			
			ResultSet results = ps.executeQuery();
			
			while(results.next()) {
				Record record = new Record();
				
				record.setId(results.getInt("id"));
				record.setDate(results.getDate("date"));
				record.setTime(results.getString("time"));
				record.setDistance(results.getDouble("distance"));
				record.setType(results.getString("type"));
				record.setUnit(results.getString("unit"));
				
				records.add(record);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) {
					ps.close();
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
		
		return records;
	}
	@Override
	public List<Record> listAll() {
		List<Record> records = new ArrayList<Record>();
		try {
			Class.forName(Resources.JDBC_DRIVER).newInstance();
			con = DriverManager.getConnection(Resources.DB_URL, Resources.USER, Resources.PASS);			
			
			ps = con.prepareStatement("SELECT * FROM records");			
			ResultSet results = ps.executeQuery();
			
			while(results.next()) {
				Record record = new Record();
				
				record.setId(results.getInt("id"));
				record.setDate(results.getDate("date"));
				record.setTime(results.getString("time"));
				record.setDistance(results.getDouble("distance"));
				record.setType(results.getString("type"));
				record.setUnit(results.getString("unit"));
				
				records.add(record);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) {
					ps.close();
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
		
		return records;
	}
}