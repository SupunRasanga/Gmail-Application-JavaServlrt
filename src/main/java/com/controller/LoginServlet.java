package com.controller;

import java.io.IOException;
import java.security.Provider.Service;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.UserDTO;
import com.service.Services;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post");
		//Get user inputs for variable
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		try {
			
			UserDTO ud = Services.getUserAuthentication(email);
			String userEmail = ud.getGmail();
			String userPassword = ud.getPassword();
			
			//Pass value for alert
			
			//check authentication
			if((userEmail != null && userEmail.equals(email)) && (userPassword != null && userPassword.equals(password))){
				
				//call method
				RequestDispatcher dispactcher = request.getRequestDispatcher("inbox.jsp");
				dispactcher.forward(request, response);
				System.out.println("Login Sucessfull");
			}else {
				
				//call method
				RequestDispatcher dispactcher = request.getRequestDispatcher("register.jsp");
				dispactcher.forward(request, response);
				System.out.println("Login Faild");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
