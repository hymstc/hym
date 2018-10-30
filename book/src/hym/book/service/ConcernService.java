package hym.book.service;

import java.util.Collection;

import hym.book.Class.Concern;

//������ҵ��ӿ�
public interface ConcernService {
	// ��ȡȫ���ĳ�����
	Collection<Concern> getAll();

	// ����id����һ��������
	Concern find(String id);

	// ���һ��������
	Concern add(Concern c);

	// �޸�һ��������
	Concern update(Concern c);
	
	//ɾ��һ��������
	void remove(Concern c);
	
	// ���ݳ���������ģ������
	Collection<Concern> query(String name);
}
