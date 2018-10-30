package hym.book.dao;

import java.util.Collection;

import hym.book.Class.InRecord;

//����¼DAO�ӿ�
public interface InRecordDao {

	// �������������������¼, begin��ʼ���ڵ��ַ��� end�������ڵ��ַ�
	Collection<InRecord> findByDate(String begin, String end);
	
	//����������������¼
	Collection<InRecord> findByBook(String bookName);
	
	// ��������¼id�������¼����
	InRecord findById(String id);

	// ����һ������¼
	String save(InRecord r);
}
