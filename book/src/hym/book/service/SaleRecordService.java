package hym.book.service;

import java.util.Collection;
import java.util.Date;

import hym.book.Class.SaleRecord;

// ����ҵ��ӿ�
public interface SaleRecordService {
	// ����һ�����ۼ�¼�������ݷ���ֵ�жϿ���Ƿ����
	boolean saveRecord(SaleRecord record);

	// �������ڻ�ȡ�����ڶ�Ӧ�����ۼ�¼
	Collection<SaleRecord> getAll(Date date);

	// ����������ȡ��������Ӧ�����ۼ�¼
	Collection<SaleRecord> getAllBook(String BookName);

	// ����id��ȡ���ۼ�¼
	SaleRecord get(String id);
}
