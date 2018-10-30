package hym.book.dao.impl;

import java.util.Collection;
import java.util.Vector;

import hym.book.Class.BookInRecord;
import hym.book.Class.BookSaleRecord;
import hym.book.dao.BookInRecordDao;

//�鱾���DAOʵ����
public class BookInRecordDaoImpl extends CommonDaoImpl implements
		BookInRecordDao {

	@Override
	//���ݿ���¼id�����Ŀ���¼����
	public Collection<BookInRecord> findByInRecord(String inRecordId) {
		String sql = "SELECT * FROM T_BOOK_IN_RECORD r WHERE r.T_IN_RECORD_ID_FK='" + 
		inRecordId + "'";
		return getDatas(sql, new Vector(), BookInRecord.class);
	}
	//���ݿ���¼book_name�����Ŀ���¼����
	@Override
	public Collection<BookInRecord> findBookByInRecord(String BookName) {
		String sql = "SELECT * FROM T_BOOK_IN_RECORD r WHERE r.T_IN_RECORD_ID_FK='" + 
		BookName + "'";
		return getDatas(sql, new Vector(), BookInRecord.class);
	}
	
	@Override
	public String save(BookInRecord r) {
		String sql = "INSERT INTO T_BOOK_IN_RECORD VALUES (ID, '" + r.getBook().getID() + 
		"', '" + r.getT_IN_RECORD_ID_FK() + "', '" + r.getIN_SUM() + "')";
		return String.valueOf(getJDBCExecutor().executeUpdate(sql));

	}


}
