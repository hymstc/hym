package hym.book.service.impl;

import java.util.Collection;

import hym.book.Class.Book;
import hym.book.Class.Concern;
import hym.book.Class.Type;
import hym.book.dao.BookDao;
import hym.book.dao.ConcernDao;
import hym.book.dao.TypeDao;
import hym.book.service.BookService;

//书本业务实现类
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
		//查找书对应的种类
		Type type = typeDao.find(book.getTYPE_ID_FK());
		//查找书的出版社
		Concern concern = concernDao.find(book.getPUB_ID_FK());
		book.setType(type);
		book.setConcern(concern);
		return book;
	}

	@Override
	public Collection<Book> getAll() {
		Collection<Book> result = bookDao.findAll();
		//调用setAssociate方法设置关联的两个对象
		return setAssociate(result);
	}
	
	//设置关系对象
	private Collection<Book> setAssociate(Collection<Book> result) {
		//遍历结果集合，设置每一个书的对象
		for (Book book : result) {
			//查找出对应的种类，再为书设置种类对象
			book.setType(typeDao.find(book.getTYPE_ID_FK()));
			//查找出对应的出版社，再为书设置出版社对象
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
