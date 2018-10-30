package hym.book.service;

import java.util.Collection;

import hym.book.Class.Book;

//书本业务接口
public interface BookService {

	//查找全部的书
	Collection<Book> getAll();
	//根据id获取书
	Book get(String id);
	//新增一本书
	Book add(Book book);
	 //修改一本书
	Book update(Book book);
	 //根据名称模糊查询
	Collection<Book> find(String name);
	//删除一本书
	void remove(Book book);
}
