package ie.tom.timekeeper.database.handlers;

import java.util.List;

import ie.tom.timekeeper.entity.Record;

public interface RecordDao {
	void insertRecord(Record record);
	List<Record> listRecords();
	List<Record> listAll();
}