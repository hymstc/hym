package hym.book.dao;

import java.util.Collection;

import hym.book.Class.BookInRecord;

	//�鱾����¼DAO�ӿ�
public interface BookInRecordDao {

	// ��������¼id����ȫ�����������¼
	Collection<BookInRecord> findByInRecord(String inRecordId);

	// ����һ���������¼, �����ظü�¼��id
	String save(BookInRecord r);
	// ��������¼Name����ȫ�����������¼
	Collection<BookInRecord> findBookByInRecord(String BookName);
}
