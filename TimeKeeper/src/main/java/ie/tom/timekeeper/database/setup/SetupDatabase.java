package ie.tom.timekeeper.database.setup;

public class SetupDatabase {

	public SetupDatabase() {
		buildDatabase();
		buildTable();
	}
	private void buildDatabase() {
		CreateDatabase database = new CreateDatabase();
		database.createDatabase();
	}
	private void buildTable() {
		CreateTable record = new CreateTableRecord();
		record.createTable();
	}
	@SuppressWarnings("unused")
	private void connectDatabase() {
                
	}
}