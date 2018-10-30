package hym.book.service;

import java.util.Collection;

import hym.book.Class.Concern;

//出版社业务接口
public interface ConcernService {
	// 获取全部的出版社
	Collection<Concern> getAll();

	// 根据id查找一个出版社
	Concern find(String id);

	// 添加一个出版社
	Concern add(Concern c);

	// 修改一个出版社
	Concern update(Concern c);
	
	//删除一个出版社
	void remove(Concern c);
	
	// 根据出版社名字模糊查找
	Collection<Concern> query(String name);
}
