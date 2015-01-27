package ie.tom.timekeeper.database.handlers;

import java.util.List;

import ie.tom.timekeeper.entity.Record;

public interface RecordDao {
	void insertRecord(Record record);
	List<Record> listRecords(int month, String year, String type, String unit);
	List<Record> listAll();
}