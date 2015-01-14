package ie.tom.timekeeper.database.setup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SetupDatabase {
        // JDBC driver name and database URL
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        static final String DB_URL = "jdbc:mysql://localhost/cardio_records";
        static final String DB_NAME = "cardio_records";
        
        //  Database credentials
        static final String USER = "root";
        static final String PASS = "";
        private Connection conn = null;
        private Statement stmt;
        
        public SetupDatabase() {
                buildDatabase();
                //connectDatabase();
        }
        private void buildDatabase() {
                CreateDatabase database = new CreateDatabase();
                database.createDatabase();
                CreateTable record = new CreateTableRecord();
                record.createTable();
        }
        private void connectDatabase() {
                
        }
}