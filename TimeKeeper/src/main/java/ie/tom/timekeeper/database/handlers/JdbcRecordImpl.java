package ie.tom.timekeeper.database.handlers;

import ie.tom.timekeeper.Resources;
import ie.tom.timekeeper.entity.Record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
	public List<Record> listRecords() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Record> listAll() {
		
		
		return null;
	}
}