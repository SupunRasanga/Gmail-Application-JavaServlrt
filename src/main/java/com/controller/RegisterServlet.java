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
		us.setFirstName(request.getParameter("fName"));	request.setAttribute("fName", request.getParameter("fName") );
		us.setLastName(request.getParameter("lName"));	request.setAttribute("lName", request.getParameter("lName") );	
		us.setDob(request.getParameter("dob"));			request.setAttribute("dob", request.getParameter("dob") );
		us.setContactNo(request.getParameter("conNo"));	request.setAttribute("conNo", request.getParameter("conNo") );


		System.out.println(request.getParameter("gender"));
		
		
		//Get Passwords
		String pass = request.getParameter("pass");
		String comPass = request.getParameter("comPass");
		String email = null; String dbEmail = null;
		
		try {
			email = request.getParameter("email")+"gmail.com";
			UserDTO ud = Services.checkEmail(email);
			dbEmail = ud.getGmail();
			System.out.println(dbEmail);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Check Gender
		if(request.getParameter("gender")!= null) {
			us.setGender(request.getParameter("gender"));
			
		//Check Passwords
				if(pass.equals(comPass)) {
					us.setPassword(pass);	
					request.setAttribute("passwordC", pass);
					
				//Check Email
					if(email.equals(dbEmail)) {
						request.setAttribute("emailS", "Email is already exists!");
						RequestDispatcher dispactcher = request.getRequestDispatcher("register.jsp");
						dispactcher.forward(request, response);
							
						}else {
							us.setGmail(email);
							
							try {
								Services.registerUser(us);
							} catch (SQLException e) {			
								e.printStackTrace();
							}
							
							request.setAttribute("register", "User Registration Successfully !");
							RequestDispatcher dispactcher = request.getRequestDispatcher("register.jsp");
							dispactcher.forward(request, response);
						}
					
					
					
					
				}else if(email.equals(dbEmail)) {
					request.setAttribute("emailS", "Email is already exists!");
					request.setAttribute("password", "Passwords doesn't match !");
					request.setAttribute("passwordC", pass);
					RequestDispatcher dispactcher = request.getRequestDispatcher("register.jsp");
					dispactcher.forward(request, response);
					
				} else {
					//****Call error alert
					request.setAttribute("password", "Passwords doesn't match !");
					request.setAttribute("emailC", request.getParameter("email"));
					System.out.println("Authentication error");
					RequestDispatcher dispactcher = request.getRequestDispatcher("register.jsp");
					dispactcher.forward(request, response);
				}
		
		}else {
			request.setAttribute("genderS", "Please select your gender !");
			request.setAttribute("passwordC", pass);
			request.setAttribute("emailC", request.getParameter("email"));
			RequestDispatcher dispactcher = request.getRequestDispatcher("register.jsp");
			dispactcher.forward(request, response);
		}
		
		System.out.println(us.getPassword());

	}
	
	

}
