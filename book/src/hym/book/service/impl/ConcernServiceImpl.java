package hym.book.service.impl;

import java.util.Collection;

import hym.book.Class.Concern;
import hym.book.dao.ConcernDao;
import hym.book.service.ConcernService;

//出版社业务实现类
public class ConcernServiceImpl implements ConcernService {

	private ConcernDao concerndao;
	
	public ConcernServiceImpl(ConcernDao dao) {
		this.concerndao = dao;
	}
	
	@Override
	public Collection<Concern> getAll() {
		return concerndao.findAll();
	}

	@Override
	public Concern find(String id) {
		return concerndao.find(id);
	}

	@Override
	public Concern add(Concern c) {
		String id = concerndao.add(c);
		return find(id);
	}

	@Override
	public Concern update(Concern c) {
		//调用DAO方法修改对象
		String id = concerndao.update(c);
		//重新查找该对象
		return find(id);
	}

	@Override
	public Collection<Concern> query(String name) {
		return concerndao.findByName(name);
	}

	@Override
	public void remove(Concern c) {
		String id =concerndao.remove(c);
	}

}
