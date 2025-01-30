package com.tapfoods.userDAO;

import java.util.List;

import com.tapfoods.module.order;

public interface orderDAO {
	void addOrder(order order);
	order getOrder(int orderid);
	void updateOrder(order order);
	void deleteOrder(int orderid);
	List<order> getAllOrder();
	
}
