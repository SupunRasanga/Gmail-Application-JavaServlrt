package com.controller;

import java.io.IOException;
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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDTO us = new UserDTO();
		us.setFirstName(request.getParameter("fName"));
		us.setLastName(request.getParameter("lName"));
		us.setDob(request.getParameter("dYear")+'-'+ request.getParameter("dMonth")+'-'+request.getParameter("dDay"));
		us.setGender(request.getParameter("gender"));
		us.setContactNo(request.getParameter("conNo"));
		
		
		
		
		
		
		//Check Passwords
		String pass = request.getParameter("pass");
		String comPass = request.getParameter("comPass");
		if(pass.equals(comPass)) {
			us.setPassword(pass);
			//Check Email
			try {
				String email = request.getParameter("email");
				UserDTO ud = Services.checkEmail(email);
				String dbEmail = ud.getGmail();
				
				if(email.equals(dbEmail)) {
					//****Call error alert
					
					RequestDispatcher dispactcher = request.getRequestDispatcher("register.jsp");
					dispactcher.forward(request, response);
					
				}else {
					us.setGmail(email);
					Services.registerUser(us);
					RequestDispatcher dispactcher = request.getRequestDispatcher("register.jsp");
					dispactcher.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else {
			//****Call error alert
			System.out.println("Authentication error");
			RequestDispatcher dispactcher = request.getRequestDispatcher("register.jsp");
			dispactcher.forward(request, response);
		}
		
		System.out.println(us.getFirstName());
		
		
	}
	
	

}
