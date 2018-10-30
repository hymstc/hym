package hym.book.service;

import java.util.Collection;

import hym.book.Class.Book;

//�鱾ҵ��ӿ�
public interface BookService {

	//����ȫ������
	Collection<Book> getAll();
	//����id��ȡ��
	Book get(String id);
	//����һ����
	Book add(Book book);
	 //�޸�һ����
	Book update(Book book);
	 //��������ģ����ѯ
	Collection<Book> find(String name);
	//ɾ��һ����
	void remove(Book book);
}
