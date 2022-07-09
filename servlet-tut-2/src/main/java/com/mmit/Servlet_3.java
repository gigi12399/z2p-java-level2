package com.mmit;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/servlet-3"})
public class Servlet_3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Servlet_3() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 
		LocalDate date = LocalDate.now();
		req.setAttribute("currentDate", date);
		
		PrintWriter out = resp.getWriter();
		var name = req.getParameter("uname");
		var password = req.getParameter("upass");
		out.write("<html>");
		out.write("<body>");
		out.print("<h3>Servlet 02</h3>");
		out.print("<h5>User name: " + name + "</h5>");
		out.print("<h5>Password: " + password + "</h5>");
		out.print("<hr>");
		getServletContext().getRequestDispatcher("/servlet-4").include(req, resp);
		out.print("</body></html>");
		
		
		req.getAttribute("currentDate");// return null
	}

	

}
