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
import javax.servlet.http.HttpSession;

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
		
		//Get user inputs for variable
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		try {
			
			UserDTO ud = Services.getUserAuthentication(email);
			String userEmail = ud.getGmail();
			String userPassword = ud.getPassword();
			
			//Pass value for alert
			
			//check authentication
			if((userEmail != null && userEmail.equals(email))){
				
				if(userPassword != null && userPassword.equals(password)) {
					
					//call method
					HttpSession session = request.getSession(true);
					session.setAttribute("sessionEmail", email);
					
					Services.session = (String) session.getAttribute("sessionEmail");	
					System.out.println(Services.session+"Session correct");
					RequestDispatcher dispactcher = request.getRequestDispatcher("inbox.jsp");
					dispactcher.forward(request, response);
					System.out.println("Login Sucessfull");
				}else {
					request.setAttribute("emailC", email);			
					request.setAttribute("password", "Please Enter Correct Password !");
					RequestDispatcher dispactcher = request.getRequestDispatcher("login.jsp");
					dispactcher.forward(request, response);
				}
				
			}else if(userPassword != null && userPassword.equals(password)) {
				
				RequestDispatcher dispactcher = request.getRequestDispatcher("inbox.jsp");
				dispactcher.forward(request, response);
				System.out.println("Login Sucessfull");
			}else{
				
				//call method
				request.setAttribute("email", "Please Enter Valid Email !");
				request.setAttribute("password", "Please Enter Correct Password !");
				RequestDispatcher dispactcher = request.getRequestDispatcher("login.jsp");
				dispactcher.forward(request, response);
				System.out.println("Login Faild");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
