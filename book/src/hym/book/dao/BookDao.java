package hym.book.dao;

import java.util.Collection;

import hym.book.Class.Book;

//�鱾DAO�ӿ�
public interface BookDao {

	// ����ȫ�����鱾
	Collection<Book> findAll();

	// �����鱾ID��ȡ��
	Book find(String id);

	// ���һ����, ��������Ӻ����id
	String add(Book book);

	// �޸�һ����, �������id
	String update(Book book);
	
	//ɾ��һ����,���ظ���id
	String remove(Book book);
	// ����������ģ��������
	Collection<Book> findByName(String name);

	// �޸���Ŀ��
	void updateRepertory(Book b);

}
