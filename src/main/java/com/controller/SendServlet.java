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
 * Servlet implementation class SendServlet
 */
@WebServlet("/send")
public class SendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		UserDTO us = new UserDTO();
		String email = request.getParameter("to");
		us.setSubject(request.getParameter("subject"));
		us.setMessage(request.getParameter("message"));
		String confirm = request.getParameter("confirm");

		HttpSession session = request.getSession(true);
		us.setSender(session.getAttribute("sessionEmail"));
		System.out.println("Sender is = ");
		System.out.println(us.getSender());
		
		//check Email  Availability
		try {
			UserDTO ud = Services.checkEmail(email);
			String dbEmail = ud.getGmail();
			
			System.out.println(us.getSender());
			System.out.println(us.getReceiver());
			
			ud.setReceiver(email);
			ud.setSender(session.getAttribute("sessionEmail"));
			
			System.out.println("1 "+email);
			System.out.println("2 "+ud.getSender());
			System.out.println("3 "+ud.getReceiver());
			System.out.println("4 "+dbEmail);
			
			if((email != null) && (ud.getSender() != (ud.getReceiver())) && 
			email.equals(dbEmail) && 
			(dbEmail != (session.getAttribute("sessionEmail")))) {
				us.setReceiver(email);
				us.setSender(session.getAttribute("sessionEmail"));
				//checking draft or send
				if(request.getParameter("send") != null) {
					
					if(email != (session.getAttribute("sessionEmail"))){
						Services.sendMail(us);
						request.setAttribute("status", "Send");
						System.out.println("Email is sended!");
						RequestDispatcher dispactcher = request.getRequestDispatcher("compose.jsp");
						dispactcher.forward(request, response);

					}
					
				}else if (request.getParameter("draft")!=null){
				 Services.draftMail(us);
				 request.setAttribute("status", "Draft");
				 RequestDispatcher dispactcher = request.getRequestDispatcher("compose.jsp");
				 dispactcher.forward(request, response);

				}
					
			}
					
		else {
					//****Call error alert
					request.setAttribute("email", email);
					request.setAttribute("subject", us.getSubject());
					request.setAttribute("message", us.getMessage());
					request.setAttribute("status", "Faild");
					System.out.println("Err2");
					RequestDispatcher dispactcher = request.getRequestDispatcher("compose.jsp");
					dispactcher.forward(request, response);
				}
			
			
			System.out.println(email);
			System.out.println(dbEmail);
			
			
		} catch (SQLException e) {
			System.out.println("Err3");
			System.out.println(e);
		}
		
	}
}


