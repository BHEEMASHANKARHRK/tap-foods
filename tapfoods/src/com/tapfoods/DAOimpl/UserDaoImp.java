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

import com.tapfoods.module.user;
import com.tapfoods.userDAO.userDAO;

public class UserDaoImp implements userDAO {

	final static String INSERT_QUERY="INSERT into 'user' ('userid','name','email','phoneno','address','username','password','role') values (?,?,?,?,?,?,?,?) ";
	final static String SELECT_QUERY="SELECT * FROM  'user' WHERE 'userid' = ?";
	final static String UPDATE_QUERY="UPDATE 'user' SET 'name'=?,'email'=?,'phone'=?,'address'=?,'username'=?, 'password'=?,'role'=? WHERE 'userid'=?";
	final static String DELETE_QUERY="DELETE FROM 'user' WHERE 'userid'=?";
	final static String SELECT_ALL_QUERY="SELECT * FROM 'user";
	
	private Connection conn;
	
	
	public UserDaoImp()
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
	public void addUser(user user) {
		PreparedStatement prepareStatement = null;
		try {
			
			prepareStatement= conn.prepareStatement(INSERT_QUERY);
			
			prepareStatement.setInt(1, user.getUserid());
			prepareStatement.setString(2, user.getName());
			prepareStatement.setString(3, user.getEmail());
			prepareStatement.setInt(4, user.getPhoneno());
			prepareStatement.setString(5, user.getAddress());
			prepareStatement.setString(6, user.getUsername());
			prepareStatement.setString(7, user.getPassword());
			prepareStatement.setString(8, user.getRole());
			
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public user getUser(int userid) {
		PreparedStatement statement= null;
		ResultSet res= null;
		user user= null;
		try {
			statement= conn.prepareStatement(SELECT_QUERY);
			statement.setInt(1, userid);
			
			res=statement.executeQuery();
			
			if(res.next())
			{
				String name=res.getString("name");
				String email=res.getString("email");
				int phoneno=res.getInt("phoneno");
				String address=res.getString("address");
				String username=res.getString("username");
				String password=res.getString("password");
				String role=res.getString("role");
				Date createDate=res.getDate("createDate");
				Date lastlogin=res.getDate("lastlogin");
				
				user = new user(userid,name,email,phoneno,address,username,password,role);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateUser(user user) {
		PreparedStatement statement= null;

		try {
			statement = conn.prepareStatement(UPDATE_QUERY);
			
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setInt(3, user.getPhoneno());
			statement.setString(4, user.getAddress());
			statement.setString(5, user.getUsername());
			statement.setString(6, user.getPassword());
			statement.setString(7, user.getRole());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(int userid) {
		PreparedStatement statement= null;
		
		try {
			statement = conn.prepareStatement(UPDATE_QUERY);
			
			statement.setInt(1, userid);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<user> getAllUser() {
		Statement stmt = null;
		ResultSet res = null;
		user user= null;
		
		ArrayList<user> userlist = new ArrayList<user>();
		
		try {
			stmt=conn.createStatement();
			
			res=stmt.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next())
			{
				int userid=res.getInt("userid");
				String name=res.getString("name");
				String email=res.getString("email");
				int phoneno=res.getInt("phoneno");
				String address=res.getString("address");
				String username=res.getString("username");
				String password=res.getString("password");
				String role=res.getString("role");
				Date createDate=res.getDate("createDate");
				Date lastlogin=res.getDate("lastlogin");
				
				user = new user(userid,name,email,phoneno,address,username,password,role);
				
				userlist.add(user);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return userlist;
	}
	
}
