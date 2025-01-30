package com.tapfoods.DAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tapfoods.module.menu;
import com.tapfoods.module.restavrant;
import com.tapfoods.userDAO.restavrantDAO;

public class restavrantDaoImp implements restavrantDAO {
	
	final static String INSERT_QUERY="INSERT into 'restavrant' ('restavrantid','name','imagepath','rating','eat','cuisineType','address','isActive','restavrentOwnerid') values (?,?,?,?,?,?,?,?,?) ";
	final static String SELECT_QUERY="SELECT * FROM  'restavrant' WHERE 'restavrantid' = ?";
	final static String UPDATE_QUERY="UPDATE 'restavrant' SET 'name'=?,'price'=?,'decription'=?,'imagepath'=?,'isAvailable'=?, 'restavrantid'=?,'rating'=? WHERE 'menuid'=?";
	final static String DELETE_QUERY="DELETE FROM 'restavrant' WHERE 'menuid'=?";
	final static String SELECT_ALL_QUERY="SELECT * FROM 'restavrant";
	
	private Connection conn;
	
	
	public restavrantDaoImp()
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
	public void addRestavrant(restavrant restavrant) {
		PreparedStatement prepareStatement = null;
		try {
			
			prepareStatement= conn.prepareStatement(INSERT_QUERY);
			
			prepareStatement.setInt(1, restavrant.getRestavrantid());
			prepareStatement.setString(2, restavrant.getName());
			prepareStatement.setString(3, restavrant.getImagepath());
			prepareStatement.setFloat(4, restavrant.getRating());
			prepareStatement.setInt(5, restavrant.getEta());
			prepareStatement.setString(6, restavrant.getCuisineType());
			prepareStatement.setString(7, restavrant.getAddress());
			prepareStatement.setBoolean(8, restavrant.isActive());
			prepareStatement.setInt(9, restavrant.getRestavrentOwnerid());
			
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public restavrant getRestavrant(int restavrantid) {
		PreparedStatement statement= null;
		ResultSet res= null;
		restavrant restavrant= null;
		try {
			statement= conn.prepareStatement(SELECT_QUERY);
			statement.setInt(1, restavrantid);
			
			res=statement.executeQuery();
			
			if(res.next())
			{
				String name=res.getString("name");
				String imagepath=res.getString("imagepath");
				Float rating=res.getFloat("rating");
				int eta=res.getInt("eta");
				String cuisineType=res.getString("cuisineType");
				String address=res.getString("address");
				boolean isActive=res.getBoolean("isActive");
				int restavrentOwnerid=res.getInt("restavrentOwnerid");
				
				restavrant = new restavrant(restavrantid,name,imagepath,rating,eta,cuisineType,address,isActive,restavrentOwnerid);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateRestavrant(restavrant restavrant) {
		PreparedStatement statement= null;

		try {
			statement = conn.prepareStatement(UPDATE_QUERY);
			
			statement.setInt(1, restavrant.getRestavrantid());
			statement.setString(2, restavrant.getName());
			statement.setString(3, restavrant.getImagepath());
			statement.setFloat(4, restavrant.getRating());
			statement.setInt(5, restavrant.getEta());
			statement.setString(6, restavrant.getCuisineType());
			statement.setString(7, restavrant.getAddress());
			statement.setBoolean(8, restavrant.isActive());
			statement.setInt(9, restavrant.getRestavrentOwnerid());
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteRestavrant(int restavrantid) {
		PreparedStatement statement= null;
		
		try {
			statement = conn.prepareStatement(UPDATE_QUERY);
			
			statement.setInt(1, restavrantid);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<restavrant> getAllRestavrant(){
		Statement stmt = null;
		ResultSet res = null;
		restavrant restavrant= null;
		
		ArrayList<restavrant> restavrantlist = new ArrayList<restavrant>();
		
		try {
			stmt=conn.createStatement();
			
			res=stmt.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next())
			{
				int restavrantid=res.getInt("restavrantid");
				String name=res.getString("name");
				String imagepath=res.getString("imagepath");
				Float rating=res.getFloat("rating");
				int eta=res.getInt("eta");
				String cuisineType=res.getString("cuisineType");
				String address=res.getString("address");
				boolean isActive=res.getBoolean("isActive");
				int restavrentOwnerid=res.getInt("restavrentOwnerid");
				
				restavrant = new restavrant(restavrantid,name,imagepath,rating,eta,cuisineType,address,isActive,restavrentOwnerid);
				
				restavrantlist.add(restavrant);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return restavrantlist;
	}

}
