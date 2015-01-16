package ie.tom.timekeeper.database.handlers;

import ie.tom.timekeeper.entity.Record;

public interface UpdateDatabase {
	void insertRecord(Record record);
	void updateRecord(Record record);
}