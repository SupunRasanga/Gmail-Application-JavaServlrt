package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.UserDTO;
import com.util.JDBCUtil;

public class Services {
	public static String session;
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
		
		String getUserSQL = "SELECT email,password,first_name FROM users WHERE email = ?";
		UserDTO user = new UserDTO();
		try {
			connection = JDBCUtil.getConnection();
			prest = connection.prepareStatement(getUserSQL);
			prest.setString(1, email);
			ResultSet rs = prest.executeQuery();
			
			while(rs.next()) {
				user.setGmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("first_name"));
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			prest.close();
			connection.close();
		}return user;
	}
	
	//Send Mail
		public static void sendMail(UserDTO ud) throws SQLException{
			Connection connection = null;
			PreparedStatement prest = null;
			
			String innerSQL = "INSERT INTO mails (subject,message,status,position,receiver,sender,message_type) VALUES(?,?,?,?,?,?,?)";
			
			try {
				connection = JDBCUtil.getConnection();
				prest = connection.prepareStatement(innerSQL);
				prest.setString(1,ud.getSubject());
				prest.setString(2,ud.getMessage());
				prest.setString(3, "not seen");
				prest.setString(4, "inbox");
				prest.setString(5,ud.getReceiver());
				prest.setString(6,ud.getSender());
				prest.setString(7, "sent");
				
				int returnValue	= prest.executeUpdate();
				System.out.println("Retuen of Insert SQL - "+returnValue);
			
			}catch(SQLException e) {
				System.out.println("Insert Faild "+e.getMessage());
			}finally {
				prest.close();
				connection.close();
			}
		}
		
		//Draft Mail
		public static void draftMail(UserDTO ud) throws SQLException{
			Connection connection = null;
			PreparedStatement prest = null;
			
			String innerSQL = "INSERT INTO mails (subject,message,status,position,receiver,sender) VALUES(?,?,?,?,?,?)";
			
			try {
				connection = JDBCUtil.getConnection();
				prest = connection.prepareStatement(innerSQL);
				prest.setString(1,ud.getSubject());
				prest.setString(2,ud.getMessage());
				prest.setString(3, "not send");
				prest.setString(4, "draft");
				prest.setString(5,ud.getReceiver());
				prest.setString(6,ud.getSender());
				
				int returnValue	= prest.executeUpdate();
				System.out.println("Retuen of Insert SQL - "+returnValue);
				
			}catch(SQLException e) {
				System.out.println("Insert Faild "+e.getMessage());
			}finally {
				prest.close();
				connection.close();
			}
		}
		
		public static void deleteMail(String ud) throws SQLException{
			
		}
		
		//Trash
		public static void updatePosition(long id) throws SQLException {
			Connection connection = null;
			PreparedStatement preStat = null;

			String updateSQL = "UPDATE mails SET position = 'trash' where id = ?";
			long result = 0;

			try {
				connection = JDBCUtil.getConnection();
				preStat = connection.prepareStatement(updateSQL);
				preStat.setLong(1, id);

				System.out.println(preStat);

				result = preStat.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
		//Trash Sender
		public static void updateMessageType(long id) throws SQLException {
			Connection connection = null;
			PreparedStatement preStat = null;
			
			String updateSQL = "UPDATE mails SET message_type = 'trash' where id = ?";
			long result = 0;
			
			try {
				connection = JDBCUtil.getConnection();
				preStat = connection.prepareStatement(updateSQL);
				preStat.setLong(1, id);
				
				System.out.println(preStat);
				
				result = preStat.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		//Status
		public static void updateStatus(long id) throws SQLException {
			Connection connection = null;
			PreparedStatement preStat = null;
			
			String updateSQL = "UPDATE mails SET status = 'seen' where id = ?";
			long result = 0;
			
			try {
				connection = JDBCUtil.getConnection();
				preStat = connection.prepareStatement(updateSQL);
				preStat.setLong(1, id);
				
				System.out.println(preStat);
				
				result = preStat.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		//Delete
		public static void deleteEmail(long id)throws SQLException {
			Connection connection = null;
			PreparedStatement preStat = null;
			
			try {
				String deleteSQL = "DELETE FROM mails WHERE id = ?";
				connection = JDBCUtil.getConnection();
				preStat = connection.prepareStatement(deleteSQL);
				preStat.setLong(1, id);
				System.out.println(preStat);
				int returnValue = preStat.executeUpdate();
				System.out.println("Return of SQL - " + returnValue);
			} catch (Exception e) {
				System.out.println("Delete failed - " + e.getMessage());
			}finally {
				preStat.close();
				connection.close();
			}
		}
		
		//seen message
		public static long id;
		
		public static UserDTO seenEmail() throws SQLException{
			System.out.println("id ="+id);
			Connection connection = null;
			PreparedStatement prest = null;
			
			String getUserSQL = "SELECT sender,subject,message,SUBSTRING(message, 1, 120) AS message,to_char(time, 'dd-mm-yyyy HH12:MI')As time FROM mails WHERE id = ?";
			UserDTO user = new UserDTO();
			try {
				connection = JDBCUtil.getConnection();
				prest = connection.prepareStatement(getUserSQL);
				prest.setLong(1, id);
				ResultSet rs = prest.executeQuery();
				
				while(rs.next()) {
					user.setSender(rs.getString("sender"));
					user.setSubject(rs.getString("subject"));
					user.setMessage(rs.getString("message"));
					user.setTime(rs.getString("time"));
				}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}finally {
				prest.close();
				connection.close();
			}return user;
		}
		
		
}
