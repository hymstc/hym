package hym.book.dao;

import java.util.Collection;
import java.util.Date;

import hym.book.Class.SaleRecord;

//���ۼ�¼DAO�ӿ�
public interface SaleRecordDao {

	// ������������, ������������֮��Ľ��׼�¼ ,begin ��ʼ���ڵ��ַ���, ��ʽΪyyyy-MM-dd
	// end �������ڵ��ַ���,��ʽΪyyyy-MM-dd

	Collection<SaleRecord> findByDate(String begin, String end);
	//������������
	Collection<SaleRecord> findByBook(String BookName);
	// ����id�������ۼ�¼
	SaleRecord findById(String id);

	// ����һ�����ۼ�¼
	String save(SaleRecord record);

}
