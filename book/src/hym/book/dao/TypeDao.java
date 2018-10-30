package hym.book.dao;

import java.util.Collection;

import hym.book.Class.Type;

//书本种类DAO接口
public interface TypeDao {

	// 查找所有的种类
	Collection<Type> find();

	// 根据名字模糊查找种类
	Collection<Type> findByName(String name);

	// 根据id查找种类
	Type find(String id);

	// 添加一个种类
	String add(Type type);

	// 修改一个种类
	String update(Type type);

	// 删除一个种类
	String remove(Type type);
}
