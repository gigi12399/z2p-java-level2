package com.mmit;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// retrieve date from parameter
		String name = req.getParameter("username");
		String mail = req.getParameter("email");
		String age = req.getParameter("age");
		String birthday = req.getParameter("dob");
		String region_name = req.getParameter("region");
		String gender = req.getParameter("gender");
		System.out.println("Gender: " + gender);
		String add = req.getParameter("address");
		String old_std = req.getParameter("old_student");
		System.out.println("old student: " + old_std);
		
		
		// create object and assign data
		Student s = new Student();
		s.setName(name);
		s.setEmail(mail);
		s.setAge(Integer.parseInt(age));
		s.setBirthday(LocalDate.parse(birthday));
		s.setRegion(region_name);
		s.setGender(gender);
		s.setAddress(add);
		s.setOld_student(old_std == null ? false : true);
		
		// add student to scope
		req.setAttribute("student", s);
		// invoke
		getServletContext().getRequestDispatcher("/display.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
