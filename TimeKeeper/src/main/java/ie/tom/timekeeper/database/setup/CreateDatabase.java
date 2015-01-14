package ie.tom.timekeeper.database.setup;

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
                        conn = DriverManager.getConnection("jdbc:mysql://localhost/?user=root");
                        stmt = conn.createStatement();
                        int Result = stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS cardio_records");
                } catch (SQLException ex) {
                        Logger.getLogger(CreateDatabase.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                        try {
                                if(stmt!=null) {
                                    conn.close();
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