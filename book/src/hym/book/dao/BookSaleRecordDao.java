package hym.book.dao;

import java.util.Collection;

import hym.book.Class.BookSaleRecord;

//�鱾���ۼ�¼DAO�ӿ�
public interface BookSaleRecordDao {

	// �������ۼ�¼id��ȡ�����ۼ�¼�����е�������ۼ�¼
	Collection<BookSaleRecord> findBySaleRecord(String saleRecordId);

	// ����һ��������ۼ�¼
	String saveBookSaleRecord(BookSaleRecord record);

}
