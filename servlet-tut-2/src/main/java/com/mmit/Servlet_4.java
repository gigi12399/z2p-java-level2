package com.mmit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/servlet-4"})
public class Servlet_4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet_4() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// retrieve value from request
		var username = req.getParameter("uname");
		var password = req.getParameter("upass");
		PrintWriter out = resp.getWriter();
		if(username.equals("jeon") && password.equals("123")) {
			out.print("<h4><font color = 'purple'>Login Success Content</font></h4>");
		}else {
			out.print("<h4><font color = 'red'>Authentication Fail</font></h4>");
		}
		
		var obj = req.getAttribute("currentDate");
		out.print("<h2>Current date: " + obj + "</h2>");
	}

	

}
