package hym.book.service.impl;

import java.util.Collection;

import hym.book.Class.Book;
import hym.book.Class.Concern;
import hym.book.Class.Type;
import hym.book.dao.BookDao;
import hym.book.dao.ConcernDao;
import hym.book.dao.TypeDao;
import hym.book.service.BookService;

//�鱾ҵ��ʵ����
public class BookServiceImpl implements BookService {

	private BookDao bookDao;
	
	private TypeDao typeDao;
	
	private ConcernDao concernDao;
	
	public BookServiceImpl(BookDao bookDao, TypeDao typeDao, ConcernDao concernDao) {
		this.bookDao = bookDao;
		this.typeDao = typeDao;
		this.concernDao = concernDao;
	}
	
	@Override
	public Book get(String id) {
		Book book = bookDao.find(id);
		//�������Ӧ������
		Type type = typeDao.find(book.getTYPE_ID_FK());
		//������ĳ�����
		Concern concern = concernDao.find(book.getPUB_ID_FK());
		book.setType(type);
		book.setConcern(concern);
		return book;
	}

	@Override
	public Collection<Book> getAll() {
		Collection<Book> result = bookDao.findAll();
		//����setAssociate�������ù�������������
		return setAssociate(result);
	}
	
	//���ù�ϵ����
	private Collection<Book> setAssociate(Collection<Book> result) {
		//����������ϣ�����ÿһ����Ķ���
		for (Book book : result) {
			//���ҳ���Ӧ�����࣬��Ϊ�������������
			book.setType(typeDao.find(book.getTYPE_ID_FK()));
			//���ҳ���Ӧ�ĳ����磬��Ϊ�����ó��������
			book.setConcern(concernDao.find(book.getPUB_ID_FK()));
		}
		return result;
	}

	@Override
	public Book add(Book book) {
		String id = bookDao.add(book);
		return get(id);
	}

	@Override
	public Book update(Book book) {
		String id = bookDao.update(book);
		return get(id);
	}

	@Override
	public Collection<Book> find(String name) {
		Collection<Book> result = bookDao.findByName(name);
		return setAssociate(result);
	}

	@Override
	public  void remove(Book book) {
		String id = bookDao.remove(book);
	}
}
