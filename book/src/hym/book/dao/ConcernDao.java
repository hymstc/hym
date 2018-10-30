package hym.book.dao;

import java.util.Collection;

import hym.book.Class.Concern;

//������DAO�ӿ�
public interface ConcernDao {

	// ����ȫ���ĳ�����

	Collection<Concern> findAll();

	// ����ID���ҳ�����
	Concern find(String id);

	// ���һ��������
	String add(Concern concern);

	// �޸�һ��������
	String update(Concern concern);
	
	//	ɾ��һ��������
	String remove(Concern concern);
	
	// ��������ģ�����ҳ�����
	Collection<Concern> findByName(String name);
}
