package com.mmit;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Helloservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Helloservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("uname");
		var pass = request.getParameter("upass");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("Name: " + name);
		out.println("<br>Passoword: " + pass);
		out.println("<br>Current Date: " + LocalDate.now());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
