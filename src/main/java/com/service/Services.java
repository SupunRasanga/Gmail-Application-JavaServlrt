package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.UserDTO;
import com.util.JDBCUtil;

public class Services {
	//Check Email
	public static UserDTO checkEmail(String email)throws SQLException {
		System.out.println("Check Email");
		Connection connection = null;
		PreparedStatement prest = null;
		
		
		String selectSQL = "SELECT * FROM users WHERE email = ?";
		UserDTO user = new UserDTO();
		try {
			connection = JDBCUtil.getConnection();
			prest = connection.prepareStatement(selectSQL);
			prest.setString(1, email);
			ResultSet rs = prest.executeQuery();
			
			while(rs.next()) {
				user.setGmail( rs.getString("email"));
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			prest.close();
			connection.close();
		}	return user;
	}
	//User Registration
	public static void registerUser(UserDTO ud) throws SQLException{
		System.out.println("Sevices Call");
		Connection connection = null;
		PreparedStatement prest = null;
		
		String innerSQL = "INSERT INTO users (email,first_name,last_name,dob,gender,contact_no,password) VALUES(?,?,?,?,?,?,?)";
		
		try {
			connection = JDBCUtil.getConnection();
			prest = connection.prepareStatement(innerSQL);
			prest.setString(1,ud.getGmail());
			prest.setString(2,ud.getFirstName());
			prest.setString(3,ud.getLastName());
			prest.setString(4,ud.getDob());
			prest.setString(5,ud.getGender());
			prest.setString(6,ud.getContactNo());
			prest.setString(7,ud.getPassword());
			
			int returnValue	= prest.executeUpdate();
			System.out.println("Retuen of Insert SQL - "+returnValue);
		
		}catch(SQLException e) {
			System.out.println("Insert Faild "+e.getMessage());
		}finally {
			prest.close();
			connection.close();
		}
	}
	
	//User Login
	public static UserDTO getUserAuthentication(String email) throws SQLException{
		System.out.println("Check Login");
		Connection connection = null;
		PreparedStatement prest = null;
		
		String getUserSQL = "SELECT email,password FROM users WHERE email = ?";
		UserDTO user = new UserDTO();
		try {
			connection = JDBCUtil.getConnection();
			prest = connection.prepareStatement(getUserSQL);
			prest.setString(1, email);
			ResultSet rs = prest.executeQuery();
			
			while(rs.next()) {
				user.setGmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			prest.close();
			connection.close();
		}return user;
	}
	
}
