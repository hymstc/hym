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

//����¼ҵ��ʵ����
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
		//�õ���һ��
		Date nextDate = DateUtil.getNextDate(date);
		//�õ����������, ��ʽΪyyyy-MM-dd
		String today = DateUtil.getDateString(date);
		//�õ����������, ��ʽΪyyyy-MM-dd
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
		//���ü�¼�е�ÿһ����
		setBook(birs);
		//��������¼�е��������¼
		r.setBookInRecords((Vector<BookInRecord>)birs);
		//��������
		r.setBookNames(getBookNames(birs));
		//����������
		r.setAmount(getAmount(birs));
		return r;
	}	
	//��ȡһ������¼�������鱾�Ľ�����
	private int getAmount(Collection<BookInRecord> birs) {
		int result = 0;
		for (BookInRecord br : birs) {
			result += Integer.valueOf(br.getIN_SUM());
		}
		return result;
	}
	
	//���ò����е�ÿһ��BookInRecord��book����
	private void setBook(Collection<BookInRecord> birs) {
		for (BookInRecord bir : birs) {
			//����ID �õ�����ѯ������
			Book book = bookDao.find(bir.getBOOK_ID_FK());
			
			bir.setBook(book);
		}
	}
	
	//��ȡһ������¼�������鱾������, �Զ��Ÿ���
	private String getBookNames(Collection<BookInRecord> birs) {
		if (birs.size() == 0) return ""; 
		StringBuffer result = new StringBuffer();
		for (BookInRecord br : birs) {
			Book book = br.getBook();
			result.append(book.getBOOK_NAME() + ", ");
		}
		//ȥ�����Ķ��Ų�����
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
			//�޸���Ŀ��
			String bookId = br.getBook().getID();
			Book b = bookDao.find(bookId);
			b.setREPERTORY_SIZE(String.valueOf(Integer.valueOf(b.getREPERTORY_SIZE()) + Integer.valueOf(br.getIN_SUM())));
			bookDao.updateRepertory(b);
		}
	}



}
