package hym.book.dao;

import java.util.Collection;
import java.util.Date;

import hym.book.Class.SaleRecord;

//销售记录DAO接口
public interface SaleRecordDao {

	// 根据两个日期, 查找两个日期之间的交易记录 ,begin 开始日期的字符串, 格式为yyyy-MM-dd
	// end 结束日期的字符串,格式为yyyy-MM-dd

	Collection<SaleRecord> findByDate(String begin, String end);
	//根据书名查找
	Collection<SaleRecord> findByBook(String BookName);
	// 根据id查找销售记录
	SaleRecord findById(String id);

	// 保存一条销售记录
	String save(SaleRecord record);

}
