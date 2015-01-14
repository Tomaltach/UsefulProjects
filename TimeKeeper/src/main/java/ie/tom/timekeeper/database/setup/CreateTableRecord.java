package ie.tom.timekeeper.database.setup;

import static ie.tom.timekeeper.database.setup.SetupDatabase.DB_URL;
import static ie.tom.timekeeper.database.setup.SetupDatabase.PASS;
import static ie.tom.timekeeper.database.setup.SetupDatabase.USER;
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
                        conn = DriverManager.getConnection(DB_URL, USER, PASS);
                        System.out.println("Connected database successfully...");
      
                        //STEP 3: Execute a query
                        System.out.println("Creating table in given database...");
                        stmt = conn.createStatement();
      
                        String sql = "CREATE TABLE IF NOT EXISTS records " +
                                    "(id INTEGER not NULL, " +
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