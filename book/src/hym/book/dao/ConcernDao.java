package hym.book.dao;

import java.util.Collection;

import hym.book.Class.Concern;

//出版社DAO接口
public interface ConcernDao {

	// 查找全部的出版社

	Collection<Concern> findAll();

	// 根据ID查找出版社
	Concern find(String id);

	// 添加一个出版社
	String add(Concern concern);

	// 修改一个出版社
	String update(Concern concern);
	
	//	删除一个出版社
	String remove(Concern concern);
	
	// 根据名字模糊查找出版社
	Collection<Concern> findByName(String name);
}
