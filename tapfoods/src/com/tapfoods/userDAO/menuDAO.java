package com.tapfoods.userDAO;

import java.util.List;

import com.tapfoods.module.menu;

public interface menuDAO {
	
	void addMenu(menu menu);
	menu getMenu(int menuid);
	void updateMenu(menu menu);
	void deleteMenu(int menuid);
	List<menu> getAllMenu();
	
}
