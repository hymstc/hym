package hym.book.dao;

import java.util.Collection;

import hym.book.Class.BookInRecord;

	//书本入库记录DAO接口
public interface BookInRecordDao {

	// 根据入库记录id查找全部的书的入库记录
	Collection<BookInRecord> findByInRecord(String inRecordId);

	// 保存一条书的入库记录, 并返回该记录的id
	String save(BookInRecord r);
	// 根据入库记录Name查找全部的书的入库记录
	Collection<BookInRecord> findBookByInRecord(String BookName);
}
