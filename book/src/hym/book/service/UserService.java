package hym.book.service;

//用户业务接口
public interface UserService {

	// 用户登录的方法, 如果登录失败，则抛出BusinessException
	void login(String name, String password);
}
