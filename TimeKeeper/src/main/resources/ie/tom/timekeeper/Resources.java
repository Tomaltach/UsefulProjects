package ie.tom.timekeeper;

public class Resources {
	public static final String DERBY_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String JDBC_DRIVER = DERBY_DRIVER;  
	public static final String DB_NAME = "cardio_records";
	public static final String DB_PORT = "3306";
	public static final String DERBY_EMBEDDED_URL = "jdbc:derby:C:\\Users\\tdonegan\\git\\UsefulProjects\\TimeKeeper\\database\\cardio_records;create=true;upgrade=true";
	public static final String MYSQL_SERVER_URL = "jdbc:mysql://localhost:" + DB_PORT + "/" + DB_NAME;
	public static final String DB_URL = DERBY_EMBEDDED_URL;

	public static final String USER = "root";
	public static final String PASS = "";
}
