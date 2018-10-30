package hym.book.service;

import java.util.Collection;
import java.util.List;

import hym.book.Class.Type;

//书本种类业务接口
public interface TypeService {

	// 查找所有的种类
	Collection<Type> getAll();

	// 根据种类名字模糊查找种类
	Collection<Type> query(String name);
	// 新增一个书本种类
	Type add(Type type);

	// 修改一个书本种类
	Type update(Type type);
	
	//删除一个书本类
	void remove(Type type);
	
	// 根据主键查找一个种类
	Type get(String id);
}
