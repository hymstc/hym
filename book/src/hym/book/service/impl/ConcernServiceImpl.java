package hym.book.service.impl;

import java.util.Collection;

import hym.book.Class.Concern;
import hym.book.dao.ConcernDao;
import hym.book.service.ConcernService;

//������ҵ��ʵ����
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
		//����DAO�����޸Ķ���
		String id = concerndao.update(c);
		//���²��Ҹö���
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
