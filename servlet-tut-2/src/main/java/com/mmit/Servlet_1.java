package com.mmit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet-1")
public class Servlet_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// retrieve value from request
		var username = req.getParameter("uname");
		var password = req.getParameter("upass");
		
		// invoke other resource using forward
		// getServletContext().getRequestDispatcher("/servlet-2").forward(req, resp);
	
		
		resp.sendRedirect(req.getContextPath() + "/servlet-2");
	}

	

}
