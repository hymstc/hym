package hym.book.service.impl;

import hym.book.Class.User;
import hym.book.dao.UserDao;
import hym.book.service.UserService;

//�û�ҵ��ʵ����
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void login(String name, String password) {
		User user = userDao.getUser(name, password);
		if (user == null) {
			System.out.println("�û����������");
		}
	}

}
