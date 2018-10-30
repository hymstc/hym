package hym.book.dao;

import java.util.Collection;

import hym.book.Class.Book;

//书本DAO接口
public interface BookDao {

	// 查找全部的书本
	Collection<Book> findAll();

	// 根据书本ID获取书
	Book find(String id);

	// 添加一本书, 并返回添加后书的id
	String add(Book book);

	// 修改一本书, 返回书的id
	String update(Book book);
	
	//删除一本书,返回该书id
	String remove(Book book);
	// 根据书名称模糊查找书
	Collection<Book> findByName(String name);

	// 修改书的库存
	void updateRepertory(Book b);

}
