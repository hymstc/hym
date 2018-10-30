package hym.book.dao;

import java.util.Collection;

import hym.book.Class.BookSaleRecord;

//书本销售记录DAO接口
public interface BookSaleRecordDao {

	// 根据销售记录id获取该销售记录下所有的书的销售记录
	Collection<BookSaleRecord> findBySaleRecord(String saleRecordId);

	// 保存一条书的销售记录
	String saveBookSaleRecord(BookSaleRecord record);

}
