package hym.book.service.impl;

import java.util.Collection;
import java.util.Date;
import java.util.Vector;

import hym.book.Class.Book;
import hym.book.Class.BookInRecord;
import hym.book.Class.InRecord;
import hym.book.Tool.DateUtil;
import hym.book.dao.BookDao;
import hym.book.dao.BookInRecordDao;
import hym.book.dao.InRecordDao;
import hym.book.service.InRecordService;

//入库记录业务实现类
public class InRecordServiceImpl implements InRecordService {

	private InRecordDao inRecordDao;
	
	private BookInRecordDao bookInRecordDao;
	
	private BookDao bookDao;
	
	public InRecordServiceImpl(InRecordDao inRecordDao, BookInRecordDao bookInRecordDao, 
			BookDao bookDao) {
		this.inRecordDao = inRecordDao;
		this.bookInRecordDao = bookInRecordDao;
		this.bookDao = bookDao;
	}
	
	@Override
	public Collection<InRecord> getAll(Date date) {
		//得到下一天
		Date nextDate = DateUtil.getNextDate(date);
		//得到今天的日期, 格式为yyyy-MM-dd
		String today = DateUtil.getDateString(date);
		//得到明天的日期, 格式为yyyy-MM-dd
		String tomorrow = DateUtil.getDateString(nextDate);
		
		Collection<InRecord> records = inRecordDao.findByDate(today, tomorrow);
		for (InRecord r : records) {
			processData(r);
		}
		return records;
	}
	@Override
	public Collection<InRecord> getAllBook(String bookName) {
		Collection<InRecord> records = inRecordDao.findByBook(bookName);
		for (InRecord r : records) {
			processData(r);
		}
		return records;
	}
	private InRecord processData(InRecord r) {
		Collection<BookInRecord> birs = bookInRecordDao.findByInRecord(r.getID());
		//设置记录中的每一本书
		setBook(birs);
		//设置入库记录中的书的入库记录
		r.setBookInRecords((Vector<BookInRecord>)birs);
		//设置书名
		r.setBookNames(getBookNames(birs));
		//设置书总数
		r.setAmount(getAmount(birs));
		return r;
	}	
	//获取一次入库记录中所有书本的交易量
	private int getAmount(Collection<BookInRecord> birs) {
		int result = 0;
		for (BookInRecord br : birs) {
			result += Integer.valueOf(br.getIN_SUM());
		}
		return result;
	}
	
	//设置参数中的每一个BookInRecord的book属性
	private void setBook(Collection<BookInRecord> birs) {
		for (BookInRecord bir : birs) {
			//根据ID 得到被查询到的书
			Book book = bookDao.find(bir.getBOOK_ID_FK());
			
			bir.setBook(book);
		}
	}
	
	//获取一次入库记录中所有书本的名字, 以逗号隔开
	private String getBookNames(Collection<BookInRecord> birs) {
		if (birs.size() == 0) return ""; 
		StringBuffer result = new StringBuffer();
		for (BookInRecord br : birs) {
			Book book = br.getBook();
			result.append(book.getBOOK_NAME() + ", ");
		}
		//去掉最后的逗号并返回
		return result.substring(0, result.lastIndexOf(","));
	}

	@Override
	public InRecord get(String id) {
		InRecord r = inRecordDao.findById(id);
		return processData(r);
	}

	@Override
	public void save(InRecord r) {
		String id = inRecordDao.save(r);
		for (BookInRecord br : r.getBookInRecords()) {
			br.setT_IN_RECORD_ID_FK(id);
			bookInRecordDao.save(br);
			//修改书的库存
			String bookId = br.getBook().getID();
			Book b = bookDao.find(bookId);
			b.setREPERTORY_SIZE(String.valueOf(Integer.valueOf(b.getREPERTORY_SIZE()) + Integer.valueOf(br.getIN_SUM())));
			bookDao.updateRepertory(b);
		}
	}



}
