package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Services;



@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("delete") != null) {
			System.out.println("delete is checked");
			long id = 0;

			id = Long.parseLong(request.getParameter("delete"));
			try {
				Services.deleteEmail(id);
				RequestDispatcher dispactcher = request.getRequestDispatcher("trash.jsp");
				dispactcher.forward(request, response);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		//seen
				if (request.getParameter("seen") != null) {
					System.out.println("seen is checked");
					long eid = 0;
					
					
					
					eid = Long.parseLong(request.getParameter("seen"));
					try {
						Services.updateStatus(eid);
						Services.id= eid;
						System.out.println(Services.seenEmail());
						System.out.println();
						RequestDispatcher dispactcher = request.getRequestDispatcher("display.jsp");
						dispactcher.forward(request, response);
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
	
	}

}
