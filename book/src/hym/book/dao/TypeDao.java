package hym.book.dao;

import java.util.Collection;

import hym.book.Class.Type;

//�鱾����DAO�ӿ�
public interface TypeDao {

	// �������е�����
	Collection<Type> find();

	// ��������ģ����������
	Collection<Type> findByName(String name);

	// ����id��������
	Type find(String id);

	// ���һ������
	String add(Type type);

	// �޸�һ������
	String update(Type type);

	// ɾ��һ������
	String remove(Type type);
}
