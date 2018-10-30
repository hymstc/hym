package hym.book.dao;

import hym.book.Class.User;

//用户DAO接口
public interface UserDao {

	User getUser(String name, String password);
}
