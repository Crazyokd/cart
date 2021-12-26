package pkg.ex11.dao;

import pkg.ex11.domain.User;

public interface UserDao {

	void add(User user);
	User search(String id);
	User search(String username, String password);
}