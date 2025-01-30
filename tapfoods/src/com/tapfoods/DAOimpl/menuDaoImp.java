package com.tapfoods.DAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tapfoods.module.menu;
import com.tapfoods.module.user;
import com.tapfoods.userDAO.menuDAO;
import com.tapfoods.userDAO.userDAO;

public class menuDaoImp implements menuDAO{
	final static String INSERT_QUERY="INSERT into 'menu' ('menuid','name','price','decription','imagepath','isAvailable','restavrantid','rating') values (?,?,?,?,?,?,?,?) ";
	final static String SELECT_QUERY="SELECT * FROM  'menu' WHERE 'menuid' = ?";
	final static String UPDATE_QUERY="UPDATE 'menu' SET 'name'=?,'price'=?,'decription'=?,'imagepath'=?,'isAvailable'=?, 'restavrantid'=?,'rating'=? WHERE 'menuid'=?";
	final static String DELETE_QUERY="DELETE FROM 'menu' WHERE 'menuid'=?";
	final static String SELECT_ALL_QUERY="SELECT * FROM 'menu";
	
	private Connection conn;
	
	
	public menuDaoImp()
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
	public void addMenu(menu menu) {
		PreparedStatement prepareStatement = null;
		try {
			
			prepareStatement= conn.prepareStatement(INSERT_QUERY);
			
			prepareStatement.setInt(1, menu.getMenuid());
			prepareStatement.setString(2, menu.getName());
			prepareStatement.setFloat(3, menu.getPrice());
			prepareStatement.setString(4, menu.getDecription());
			prepareStatement.setString(5, menu.getImagepath());
			prepareStatement.setBoolean(6, menu.isAvailable());
			prepareStatement.setInt(7, menu.getRestavrantid());
			prepareStatement.setFloat(8, menu.getRating());
			
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public menu getMenu(int menuid) {
		PreparedStatement statement= null;
		ResultSet res= null;
		menu menu= null;
		try {
			statement= conn.prepareStatement(SELECT_QUERY);
			statement.setInt(1, menuid);
			
			res=statement.executeQuery();
			
			if(res.next())
			{
				String name=res.getString("name");
				float price=res.getFloat("price");
				String decription=res.getString("decription");
				String imagepath=res.getString("imagepath");
				boolean isAvailable=res.getBoolean("isAvailable");
				int restavrantid=res.getInt("restavrantid");
				float rating=res.getFloat("rating");
				
				menu = new menu(menuid,name,price,decription,imagepath,isAvailable,restavrantid,rating);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateMenu(menu menu) {
		PreparedStatement statement= null;

		try {
			statement = conn.prepareStatement(UPDATE_QUERY);
			
			statement.setString(1, menu.getName());
			statement.setFloat(2, menu.getPrice());
			statement.setString(4, menu.getDecription());
			statement.setString(5, menu.getImagepath());
			statement.setBoolean(6, menu.isAvailable());
			statement.setInt(7, menu.getRestavrantid());
			statement.setFloat(8, menu.getRating());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteMenu(int menuid) {
		PreparedStatement statement= null;
		
		try {
			statement = conn.prepareStatement(UPDATE_QUERY);
			
			statement.setInt(1, menuid);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<menu> getAllMenu() {
		Statement stmt = null;
		ResultSet res = null;
		menu menu= null;
		
		ArrayList<menu> menulist = new ArrayList<menu>();
		
		try {
			stmt=conn.createStatement();
			
			res=stmt.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next())
			{
				int menuid=res.getInt("menuid");
				String name=res.getString("name");
				float price=res.getFloat("price");
				String decription=res.getString("decription");
				String imagepath=res.getString("imagepath");
				boolean isAvailable=res.getBoolean("isAvailable");
				int restavrantid=res.getInt("restavrantid");
				float rating=res.getFloat("rating");
				
				menu = new menu(menuid,name,price,decription,imagepath,isAvailable,restavrantid,rating);
				
				
				menulist.add(menu);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return menulist;
	}

}
