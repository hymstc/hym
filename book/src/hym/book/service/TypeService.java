package hym.book.service;

import java.util.Collection;
import java.util.List;

import hym.book.Class.Type;

//�鱾����ҵ��ӿ�
public interface TypeService {

	// �������е�����
	Collection<Type> getAll();

	// ������������ģ����������
	Collection<Type> query(String name);
	// ����һ���鱾����
	Type add(Type type);

	// �޸�һ���鱾����
	Type update(Type type);
	
	//ɾ��һ���鱾��
	void remove(Type type);
	
	// ������������һ������
	Type get(String id);
}
