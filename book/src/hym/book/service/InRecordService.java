package hym.book.service;

import java.util.Collection;
import java.util.Date;

import hym.book.Class.InRecord;

//����¼ҵ��ӿ�
public interface InRecordService {

	// ����һ������¼
	void save(InRecord r);

	// �������ڲ��Ҷ�Ӧ������¼
	Collection<InRecord> getAll(Date date);
	
	//�����������Ҷ�Ӧ������¼
	Collection<InRecord> getAllBook(String bookName);
	// ����id�������¼
	InRecord get(String id);
	
}
