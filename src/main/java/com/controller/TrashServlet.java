package com.controller;

import java.io.IOException;
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
 * Servlet implementation class TrashServlet
 */
@WebServlet("/trash")
public class TrashServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TrashServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("trash") != null) {
			System.out.println("trash is checked");
			long eid = 0;

			eid = Long.parseLong(request.getParameter("trash"));
			try {
				Services.updatePosition(eid);
				RequestDispatcher dispactcher = request.getRequestDispatcher("trash.jsp");
				dispactcher.forward(request, response);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		//Trash Sender
		if (request.getParameter("trashSender") != null) {
			System.out.println("trash is checked");
			long eid = 0;

			eid = Long.parseLong(request.getParameter("trashSender"));
			try {
				Services.updateMessageType(eid);
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
		//Draft Seen
		if (request.getParameter("draftSeen") != null) {
			System.out.println("draftSeen is checked");
			long eid = 0;
			
			
			
			eid = Long.parseLong(request.getParameter("draftSeen"));
			try {
				//Services.updateStatus(eid);
				Services.id= eid;
				System.out.println(Services.seenEmail());
				
				RequestDispatcher dispactcher = request.getRequestDispatcher("draftDisplay.jsp");
				dispactcher.forward(request, response);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

}
