package hym.book.dao;

import hym.book.Class.User;

//�û�DAO�ӿ�
public interface UserDao {

	User getUser(String name, String password);
}
