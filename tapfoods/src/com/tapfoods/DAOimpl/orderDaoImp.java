package com.tapfoods.DAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tapfoods.module.order;
import com.tapfoods.userDAO.orderDAO;

public class orderDaoImp implements orderDAO{
	

	final static String INSERT_QUERY="INSERT into 'oreder' ('orderid','restavrantid_ch','userid','totalAmount','modeOfPayment','status') values (?,?,?,?,?,?) ";
	final static String SELECT_QUERY="SELECT * FROM  'oreder' WHERE 'orderid' = ?";
	final static String UPDATE_QUERY="UPDATE 'order' SET 'restavrantid_ch'=?,'userid'=?,'totalAmount'=?,'modeOfPayment'=?,'status'=? WHERE 'orderid'=?";
	final static String DELETE_QUERY="DELETE FROM 'order' WHERE 'orderid'=?";
	final static String SELECT_ALL_QUERY="SELECT * FROM 'order";
	
	private Connection conn;
	
	
	public orderDaoImp()
	{
		String url="jdbc:mysql://localhost:3306/tapfoods";
		String username="root";
		String password="root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void addOrder(order order) {
		PreparedStatement prepareStatement = null;
		try {
			
			prepareStatement= conn.prepareStatement(INSERT_QUERY);
			
			prepareStatement.setInt(1, order.getOrderid());
			prepareStatement.setInt(2, order.getRestavrantid_ch());
			prepareStatement.setInt(3, order.getUserid());
			prepareStatement.setFloat(4, order.getTotalAmount());
			prepareStatement.setString(6, order.getModeOfPayment());
			prepareStatement.setString(7, order.getStatus());
			
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public order getOrder(int orderid) {
		PreparedStatement statement= null;
		ResultSet res= null;
		order order= null;
		try {
			statement= conn.prepareStatement(SELECT_QUERY);
			statement.setInt(1, orderid);
			
			res=statement.executeQuery();
			
			if(res.next())
			{
				int restavrantid_ch=res.getInt("restavrantid_ch");
				int userid=res.getInt("userid");
				float totalAmount=res.getInt("totalAmount");
				String modeOfPayment=res.getString("modeOfPayment");
				String status=res.getString("status");
				
				order = new order(orderid,restavrantid_ch,userid,totalAmount,modeOfPayment,status);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateOrder(order order) {
		PreparedStatement statement= null;

		try {
			statement = conn.prepareStatement(UPDATE_QUERY);
			
			statement.setInt(1, order.getOrderid());
			statement.setInt(2, order.getRestavrantid_ch());
			statement.setInt(3, order.getUserid());
			statement.setFloat(4, order.getTotalAmount());
			statement.setString(6, order.getModeOfPayment());
			statement.setString(7, order.getStatus());
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteOrder(int orderid) {
		PreparedStatement statement= null;
		
		try {
			statement = conn.prepareStatement(UPDATE_QUERY);
			
			statement.setInt(1, orderid);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<order> getAllOrder(){
		Statement stmt = null;
		ResultSet res = null;
		order order= null;
		
		ArrayList<order> orderlist = new ArrayList<order>();
		
		try {
			stmt=conn.createStatement();
			
			res=stmt.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next())
			{
				int orderid=res.getInt("orderid");
				int restavrantid_ch=res.getInt("restavrantid_ch");
				int userid=res.getInt("userid");
				float totalAmount=res.getInt("totalAmount");
				String modeOfPayment=res.getString("modeOfPayment");
				String status=res.getString("status");
				
				order = new order(orderid,restavrantid_ch,userid,totalAmount,modeOfPayment,status);
			
				
				
				
				orderlist.add(order);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return orderlist;
	}

}
