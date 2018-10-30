package hym.book.service.impl;

import java.util.Collection;

import hym.book.Class.Type;
import hym.book.dao.TypeDao;
import hym.book.dao.impl.TypeDaoImpl;
import hym.book.service.TypeService;

//书本种类业务实现类
public class TypeServiceImpl implements TypeService {

	private TypeDao dao;
	
	public TypeServiceImpl(TypeDao dao) {
		this.dao = dao;
	}
	
	public Collection<Type> query(String name) {
		return dao.findByName(name);
	}

	public Collection<Type> getAll() {
		return dao.find();
	}

	public Type add(Type type) {
		String id = dao.add(type);
		return get(id);
	}

	public Type update(Type type) {
		// TODO Auto-generated method stub
		String id = dao.update(type);
		return get(id);
	}
	
	public Type get(String id) {
		return dao.find(id);
	}

	@Override
	public void remove(Type type) {
		String id = dao.remove(type);
	}

}
