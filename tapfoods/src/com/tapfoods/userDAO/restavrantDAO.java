package com.tapfoods.userDAO;

import java.util.List;

import com.tapfoods.module.restavrant;

public interface restavrantDAO {
	
	void addRestavrant(restavrant restavrant);
	restavrant getRestavrant(int restavrantid);
	void updateRestavrant(restavrant restavrant);
	void deleteRestavrant(int restavrantid);
	List<restavrant> getAllRestavrant();
	

}
