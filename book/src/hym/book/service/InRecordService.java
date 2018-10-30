package hym.book.service;

import java.util.Collection;
import java.util.Date;

import hym.book.Class.InRecord;

//入库记录业务接口
public interface InRecordService {

	// 保存一条入库记录
	void save(InRecord r);

	// 根据日期查找对应的入库记录
	Collection<InRecord> getAll(Date date);
	
	//根据书名查找对应的入库记录
	Collection<InRecord> getAllBook(String bookName);
	// 根据id获得入库记录
	InRecord get(String id);
	
}
