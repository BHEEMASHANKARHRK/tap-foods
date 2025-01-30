package com.tapfoods.userDAO;

import java.util.List;

import com.tapfoods.module.user;

public interface userDAO {
	void addUser(user user);
	user getUser(int userid);
	void updateUser(user user);
	void deleteUser(int userid);
	List<user> getAllUser();
}
