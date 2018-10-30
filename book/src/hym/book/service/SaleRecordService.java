package hym.book.service;

import java.util.Collection;
import java.util.Date;

import hym.book.Class.SaleRecord;

// 销售业务接口
public interface SaleRecordService {
	// 新增一条销售记录，并根据返回值判断库存是否充足
	boolean saveRecord(SaleRecord record);

	// 根据日期获取该日期对应的销售记录
	Collection<SaleRecord> getAll(Date date);

	// 根据书名获取该书名对应的销售记录
	Collection<SaleRecord> getAllBook(String BookName);

	// 根据id获取销售记录
	SaleRecord get(String id);
}
