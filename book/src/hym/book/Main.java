package hym.book;

import hym.book.container.LoginFrame;
import hym.book.dao.UserDao;
import hym.book.dao.impl.UserDaoImpl;
import hym.book.service.UserService;
import hym.book.service.impl.UserServiceImpl;

//程序入口类
public class Main {


	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		UserService userService = new UserServiceImpl(userDao);
		LoginFrame loginFrame = new LoginFrame(userService);
	}

}
