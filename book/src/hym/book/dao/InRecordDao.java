package hym.book.dao;

import java.util.Collection;

import hym.book.Class.InRecord;

//入库记录DAO接口
public interface InRecordDao {

	// 根据日期区间查找入库记录, begin开始日期的字符串 end结束日期的字符
	Collection<InRecord> findByDate(String begin, String end);
	
	//根据书名查找入库记录
	Collection<InRecord> findByBook(String bookName);
	
	// 根据入库记录id获得入库记录对象
	InRecord findById(String id);

	// 保存一个入库记录
	String save(InRecord r);
}
